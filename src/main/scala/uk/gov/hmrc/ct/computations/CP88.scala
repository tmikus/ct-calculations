/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ct.computations

import uk.gov.hmrc.ct.box._
import uk.gov.hmrc.ct.computations.Validators.ComputationValidatableBox
import uk.gov.hmrc.ct.computations.retriever.ComputationsBoxRetriever

case class CP88(value: Option[Int]) extends CtBoxIdentifier(name = "Annual Investment Allowance") with CtOptionalInteger with Input with ComputationValidatableBox[ComputationsBoxRetriever] {
  override def validate(boxRetriever: ComputationsBoxRetriever) = {
    validateZeroOrPositiveInteger(this) ++
      fieldhasValueWhenTrading(boxRetriever, "CP88", value) ++
      firstYearAllowanceNotGreaterThanMaxFYA(boxRetriever)
  }

  private def firstYearAllowanceNotGreaterThanMaxFYA(retriever: ComputationsBoxRetriever): Set[CtValidation] = {
    val expenditureQualifyingForFirstYearAllowanceInput: Option[Int] = retriever.retrieveCP81Input().value
    val aiaThreshold: Int = retriever.retrieveCATO02().value

    val maxAIA = Math.min(expenditureQualifyingForFirstYearAllowanceInput.getOrElse(0), aiaThreshold)

    value match {
      case Some(aiaClaimed) =>
        if(aiaClaimed <= maxAIA)
          Set()
        else
          Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.annualInvestmentAllowanceExceeded"))
      case _ => Set()
    }
  }
}

object CP88 {

  def apply(value: Int): CP88 = new CP88(Some(value))
}






