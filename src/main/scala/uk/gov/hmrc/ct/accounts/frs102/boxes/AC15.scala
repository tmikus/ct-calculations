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

package uk.gov.hmrc.ct.accounts.frs102.boxes

import uk.gov.hmrc.ct.accounts.frs102.retriever.FullAccountsBoxRetriever
import uk.gov.hmrc.ct.box._

case class AC15(value: Option[Int]) extends CtBoxIdentifier(name = "Cost of sales (current PoA)")
  with CtOptionalInteger
  with Input
  with ValidatableBox[FullAccountsBoxRetriever]
  with Validators
  with Debit {

  override def validate(boxRetriever: FullAccountsBoxRetriever): Set[CtValidation] = {
//    val fieldValidation = validateMoney(value)
//    import boxRetriever._
//    val anyProfitOrLossFieldHasAValue =
//      (value orElse
//        ac18().value orElse
//        ac20().value orElse
//        ac28().value orElse
//        ac30().value orElse
//        ac34().value)
//        .nonEmpty
//
//    if (fieldValidation.isEmpty && !anyProfitOrLossFieldHasAValue) {
//      Set(CtValidation(boxId = None, "error.frs102.profit.loss.one.box.required"))
//    } else {
//      fieldValidation
//    }
    ???
  }
}
