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

package uk.gov.hmrc.ct.accounts.frs10x.abridged.loansToDirectors

import uk.gov.hmrc.ct.accounts.frs10x.abridged.calculations.LoansToDirectorsCalculator
import uk.gov.hmrc.ct.box._

case class AC309A(value: Option[Int]) extends CtBoxIdentifier(name = "Loan Balance at end of POA")
  with CtOptionalInteger {
}

object AC309A extends CompoundCalculated[AC309A, LoanToDirector] with LoansToDirectorsCalculator {

  override def calculate(loan: LoanToDirector): AC309A = {
    calculateLoanBalanceAtEndOfPOA(
      loan.ac306A,
      loan.ac307A,
      loan.ac308A
    )
  }
}