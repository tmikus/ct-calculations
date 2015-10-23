/*
 * Copyright 2015 HM Revenue & Customs
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

package uk.gov.hmrc.ct

import uk.gov.hmrc.ct.box.{Calculated, CtBoxIdentifier, CtInteger}
import uk.gov.hmrc.ct.computations.calculations.WritingDownAllowanceCalculator
import uk.gov.hmrc.ct.computations.retriever.ComputationsBoxRetriever

case class CATO03(value: Int) extends CtBoxIdentifier(name = "Write down allowance limit") with CtInteger

object CATO03 extends Calculated[CATO03, ComputationsBoxRetriever] with WritingDownAllowanceCalculator {

  override def calculate(fieldValueRetriever: ComputationsBoxRetriever): CATO03 = {
    super.calculate(cp1 = fieldValueRetriever.retrieveCP1(),
                    cp2 = fieldValueRetriever.retrieveCP2(),
                    cp78 = fieldValueRetriever.retrieveCP78(),
                    cp82 = fieldValueRetriever.retrieveCP82(),
                    cp84 = fieldValueRetriever.retrieveCP84(),
                    cp88 = fieldValueRetriever.retrieveCP88())
  }
}