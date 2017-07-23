/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.ct.ct600.v3

import uk.gov.hmrc.ct.box.ValidatableBox._
import uk.gov.hmrc.ct.box._
import uk.gov.hmrc.ct.ct600.v3.retriever.RepaymentsBoxRetriever

case class B935(value: String) extends CtBoxIdentifier("account name")
with CtString with Input with ValidatableBox[RepaymentsBoxRetriever] {

  override def validate(boxRetriever: RepaymentsBoxRetriever): Set[CtValidation] = {
    validateAllFilledOrEmptyStringsForBankDetails(boxRetriever,"B935") ++
      validateStringByLength("B935", this, 2, 28) ++
      validateStringByRegex("B935", this, ValidNonForeignLessRestrictiveCharacters)
  }
}
