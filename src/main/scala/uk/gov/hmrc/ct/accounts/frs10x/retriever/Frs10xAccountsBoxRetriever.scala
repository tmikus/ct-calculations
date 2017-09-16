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

package uk.gov.hmrc.ct.accounts.frs10x.retriever

import uk.gov.hmrc.ct.{CoHoAccountsApprovalRequired, HmrcAccountsApprovalRequired}
import uk.gov.hmrc.ct.accounts.frs10x.boxes._
import uk.gov.hmrc.ct.accounts.retriever.{AccountsApprovalRequiredBoxRetriever, AccountsBoxRetriever}
import uk.gov.hmrc.ct.box.retriever.{BoxRetriever, FilingAttributesBoxValueRetriever}

abstract class Frs10xAccountsBoxRetriever(filingAttributesBoxRetriever: FilingAttributesBoxValueRetriever)
  extends AccountsBoxRetriever(filingAttributesBoxRetriever)
    with BoxRetriever
    with AccountsApprovalRequiredBoxRetriever
    with Frs10xDirectorsBoxRetriever
    with Frs10xDormancyBoxRetriever {

  def acq8161(): ACQ8161

  def ac8081(): AC8081

  def ac8082(): AC8082

  def ac8083(): AC8083

  def ac8088(): AC8088

  def notTradedStatementRequired(): NotTradedStatementRequired = NotTradedStatementRequired.calculate(this)

  def profitAndLossStatementRequired(): ProfitAndLossStatementRequired = ProfitAndLossStatementRequired.calculate(this)

  override def coHoAccountsApprovalRequired(): CoHoAccountsApprovalRequired =
    CoHoAccountsApprovalRequired(filingAttributesBoxValueRetriever.companiesHouseFiling())

  override def hmrcAccountsApprovalRequired(): HmrcAccountsApprovalRequired =
    HmrcAccountsApprovalRequired.calculate(this)
}
