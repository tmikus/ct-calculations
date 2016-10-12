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

import org.mockito.Mockito._
import uk.gov.hmrc.ct.accounts.frs102.retriever.Frs102AccountsBoxRetriever
import uk.gov.hmrc.ct.accounts.frs102.{AccountsMoneyValidationFixture, MockFrs102AccountsRetriever}
import uk.gov.hmrc.ct.box.CtValidation

class AC12Spec extends AccountsMoneyValidationFixture[Frs102AccountsBoxRetriever] with MockFrs102AccountsRetriever {

  testAccountsMoneyValidation("AC12", AC12.apply)

  "AC12" should {
    "AC12 has a valid value" when {
      "pass validation if all fields have a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(Some(18)))
        when(boxRetriever.ac20()).thenReturn(AC20(Some(20)))
        when(boxRetriever.ac28()).thenReturn(AC28(Some(28)))
        when(boxRetriever.ac30()).thenReturn(AC30(Some(30)))
        when(boxRetriever.ac34()).thenReturn(AC34(Some(34)))
        AC12(Some(10)).validate(boxRetriever) shouldBe empty
      }
      "pass validation if AC12 and 1 field has a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(Some(18)))
        when(boxRetriever.ac20()).thenReturn(AC20(None))
        when(boxRetriever.ac28()).thenReturn(AC28(None))
        when(boxRetriever.ac30()).thenReturn(AC30(None))
        when(boxRetriever.ac34()).thenReturn(AC34(None))
        AC12(Some(10)).validate(boxRetriever) shouldBe empty
      }
      "pass validation if 1 field has a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(None))
        when(boxRetriever.ac20()).thenReturn(AC20(None))
        when(boxRetriever.ac28()).thenReturn(AC28(None))
        when(boxRetriever.ac30()).thenReturn(AC30(None))
        when(boxRetriever.ac34()).thenReturn(AC34(None))
        AC12(Some(10)).validate(boxRetriever) shouldBe empty
      }
    }
    "AC12 has an invalid value" when {
      "pass validation if all fields have a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(Some(18)))
        when(boxRetriever.ac20()).thenReturn(AC20(Some(20)))
        when(boxRetriever.ac28()).thenReturn(AC28(Some(28)))
        when(boxRetriever.ac30()).thenReturn(AC30(Some(30)))
        when(boxRetriever.ac34()).thenReturn(AC34(Some(34)))
        AC12(Some(100000000)).validate(boxRetriever) shouldBe Set(CtValidation(boxId = Some("AC12"), "error.AC12.above.max", Some(Seq("-99999999", "99999999"))))
      }
      "pass validation if AC12 and 1 field has a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(Some(18)))
        when(boxRetriever.ac20()).thenReturn(AC20(None))
        when(boxRetriever.ac28()).thenReturn(AC28(None))
        when(boxRetriever.ac30()).thenReturn(AC30(None))
        when(boxRetriever.ac34()).thenReturn(AC34(None))
        AC12(Some(100000000)).validate(boxRetriever) shouldBe Set(CtValidation(boxId = Some("AC12"), "error.AC12.above.max", Some(Seq("-99999999", "99999999"))))
      }
      "pass validation if 1 field has a valid value" in {
        when(boxRetriever.ac18()).thenReturn(AC18(None))
        when(boxRetriever.ac20()).thenReturn(AC20(None))
        when(boxRetriever.ac28()).thenReturn(AC28(None))
        when(boxRetriever.ac30()).thenReturn(AC30(None))
        when(boxRetriever.ac34()).thenReturn(AC34(None))
        AC12(Some(100000000)).validate(boxRetriever) shouldBe Set(CtValidation(boxId = Some("AC12"), "error.AC12.above.max", Some(Seq("-99999999", "99999999"))))
      }
    }
  }
}
