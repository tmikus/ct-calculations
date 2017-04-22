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

package uk.gov.hmrc.ct.computations

import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.{Matchers, WordSpec}
import uk.gov.hmrc.ct.box.CtValidation
import uk.gov.hmrc.ct._
import uk.gov.hmrc.ct.computations.retriever.ComputationsBoxRetriever

class MachineryAndPlantValidationSpec extends WordSpec with Matchers with MockitoSugar {

  trait TestFixture {
    val computationsBoxRetriever = mock[ComputationsBoxRetriever]

    def withBox(cpq8: CPQ8) = when(computationsBoxRetriever.cpQ8()).thenReturn(cpq8)

    def withBox(cp78: CP78) = when(computationsBoxRetriever.cp78()).thenReturn(cp78)

    def withBox(cp79: CP79) = when(computationsBoxRetriever.cp79()).thenReturn(cp79)

    def withBox(cp80: CP80) = when(computationsBoxRetriever.cp80()).thenReturn(cp80)

    def withBox(cp82: CP82) = when(computationsBoxRetriever.cp82()).thenReturn(cp82)

    def withBox(cp83: CP83) = when(computationsBoxRetriever.cp83()).thenReturn(cp83)

    def withBox(cp87Input: CP87Input) = when(computationsBoxRetriever.cp87Input()).thenReturn(cp87Input)

    def withBox(cp666: CP666) = when(computationsBoxRetriever.cp666()).thenReturn(cp666)

    def withBox(cp667: CP667) = when(computationsBoxRetriever.cp667()).thenReturn(cp667)

    def withBox(cp672: CP672) = when(computationsBoxRetriever.cp672()).thenReturn(cp672)

    def withBox(cpAaux1: CPAux1) = when(computationsBoxRetriever.cpAux1()).thenReturn(cpAaux1)

    def withBox(cpAux2: CPAux2) = when(computationsBoxRetriever.cpAux2()).thenReturn(cpAux2)

    def withBox(cpAux3: CPAux3) = when(computationsBoxRetriever.cpAux3()).thenReturn(cpAux3)

    def withBox(cato02: CATO02) = when(computationsBoxRetriever.cato02()).thenReturn(cato02)

    def withBox(cato21: CATO21) = when(computationsBoxRetriever.cato21()).thenReturn(cato21)

    def withBox(cato22: CATO22) = when(computationsBoxRetriever.cato22()).thenReturn(cato22)
  }

  "CP78 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP78(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP78(None).validate(computationsBoxRetriever) shouldBe Set()
      CP78(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP78"), errorMessageKey = "error.CP78.mustBeZeroOrPositive"))
    }
  }

  "CP666 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP666(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP666(None).validate(computationsBoxRetriever) shouldBe Set()
      CP666(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP666"), errorMessageKey = "error.CP666.mustBeZeroOrPositive"))
    }
  }

  "CP79" should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP79(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP79(None).validate(computationsBoxRetriever) shouldBe Set()
      CP79(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP79"), errorMessageKey = "error.CP79.mustBeZeroOrPositive"))
    }
  }

  "CP80" should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP80(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP80(None).validate(computationsBoxRetriever) shouldBe Set()
      CP80(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP80"), errorMessageKey = "error.CP80.mustBeZeroOrPositive"))
    }
  }

  "CP82 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP82(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP82(None).validate(computationsBoxRetriever) shouldBe Set()
      CP82(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP82"), errorMessageKey = "error.CP82.mustBeZeroOrPositive"))
    }
  }

  "CP83 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP83(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP83(None).validate(computationsBoxRetriever) shouldBe Set()
      CP83(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP83"), errorMessageKey = "error.CP83.mustBeZeroOrPositive"))
    }
  }

  "CP674 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP674(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP674(None).validate(computationsBoxRetriever) shouldBe Set()
      CP674(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP674"), errorMessageKey = "error.CP674.mustBeZeroOrPositive"))
    }
  }

  "CP84 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP84(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP84(None).validate(computationsBoxRetriever) shouldBe Set()
      CP84(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP84"), errorMessageKey = "error.CP84.mustBeZeroOrPositive"))
    }
  }

  "CP252" should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP252(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP252(None).validate(computationsBoxRetriever) shouldBe Set()
      CP252(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP252"), errorMessageKey = "error.CP252.mustBeZeroOrPositive"))
    }
  }

  "CP673 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP673(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP673(None).validate(computationsBoxRetriever) shouldBe Set()
      CP673(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP673"), errorMessageKey = "error.CP673.mustBeZeroOrPositive"))
    }
  }

  "CP667 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP667(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP667(None).validate(computationsBoxRetriever) shouldBe Set()
      CP667(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP667"), errorMessageKey = "error.CP667.mustBeZeroOrPositive"))
    }
  }

  "CP672 " should {
    "validate if present and non-negative or if not present, otherwise fail" in new TestFixture {
      CP672(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP672(None).validate(computationsBoxRetriever) shouldBe Set()
      CP672(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP672"), errorMessageKey = "error.CP672.mustBeZeroOrPositive"))
    }
  }

  "CP87Input, given is trading and first Year Allowance Not Greater Than Max FYA" should {
    "validate if present and non-negative, otherwise fail" in new TestFixture {
      withBox(CPQ8(Some(false)))

      CP87Input(Some(0)).validate(computationsBoxRetriever) shouldBe Set()
      CP87Input(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP87Input"), errorMessageKey = "error.CP87Input.mustBeZeroOrPositive"))
    }
  }

  "CP87Input, given is non-negative" should {
    "validate correctly when not greater than CP81  CPaux1" in new TestFixture {
      withBox(CPQ8(Some(false)))
      withBox(CP79(Some(20)))
      withBox(CP80(Some(29)))
      withBox(CPAux1(51))

      CP87Input(Some(100)).validate(computationsBoxRetriever) shouldBe Set()
    }

    "fail validation when greater than CP81  CPaux1" in new TestFixture {
      withBox(CPQ8(Some(false)))
      withBox(CP79(Some(20)))
      withBox(CP80(Some(29)))
      withBox(CPAux1(51))

      CP87Input(Some(101)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP87Input"), errorMessageKey = "error.CP87Input.firstYearAllowanceClaimExceedsAllowance", args = Some(Seq("100"))))
    }

    "validate because FYA defaults to 0 when not entered" in new TestFixture {
      withBox(CPQ8(Some(true)))
      withBox(CP79(Some(20)))
      withBox(CP80(Some(29)))
      withBox(CPAux1(51))

      CP87Input(None).validate(computationsBoxRetriever) shouldBe Set()
    }

    "fail validation when trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(false)))

      CP87Input(None).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP87Input"), errorMessageKey = "error.CP87Input.fieldMustHaveValueIfTrading"))
    }
    "validate when ceased trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(true)))

      CP87Input(None).validate(computationsBoxRetriever) shouldBe Set()
    }
    "validate when ceased trading not set" in new TestFixture {
      CP87Input(None).validate(computationsBoxRetriever) shouldBe Set()
    }
    "fails validation when negative" in new TestFixture {
      withBox(CPQ8(Some(false)))

      CP87Input(-1).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP87Input"), errorMessageKey = "error.CP87Input.mustBeZeroOrPositive"))
    }
  }

  "CP88(annual investment allowance claimed)" should {

    "fail to validate when negative" in new TestFixture {
      CP88(Some(-1)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.mustBeZeroOrPositive"))
    }

    "validate correctly when not greater than the minimum of CATO02 (maxAIA) and CP83 (expenditureQualifyingAnnualInvestmentAllowance)" in new TestFixture {
      withBox(CP83(Some(11)))
      withBox(CATO02(10))

      CP88(Some(10)).validate(computationsBoxRetriever) shouldBe Set()
    }

    "fails validation when greater than the minimum of CATO02 (maxAIA) and CP83 (expenditureQualifyingAnnualInvestmentAllowance)" in new TestFixture {
      withBox(CP83(Some(11)))
      withBox(CATO02(10))

      CP88(Some(11)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.annualInvestmentAllowanceExceeded", args = Some(Seq("10"))))
    }

    "fails validation when CATO02 (maxAIA) is the minimum" in new TestFixture {
      withBox(CP83(Some(11)))
      withBox(CATO02(10))

      CP88(Some(11)).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.annualInvestmentAllowanceExceeded", args = Some(Seq("10"))))
    }

    "fail validation when trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(false)))
      CP88(None).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.fieldMustHaveValueIfTrading"))
    }

    "validate when ceased trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(true)))

      CP88(None).validate(computationsBoxRetriever) shouldBe Set()
    }

    "validate when ceased trading not set" in new TestFixture {
      CP88(None).validate(computationsBoxRetriever) shouldBe Set()
    }

    "fails validation when negative" in new TestFixture {
      withBox(CPQ8(Some(false)))
      CP88(-1).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP88"), errorMessageKey = "error.CP88.mustBeZeroOrPositive"))
    }
  }

  "CP89 (Writing Down Allowance claimed from Main pool)" should {

    "validates correctly when not greater than MAX(0, MainPool% * ( CP78 (Main Pool brought forward) " +
      "+ CP82 (Additions Qualifying for Main Pool) + MainRatePool - CP672 (Proceed from Disposals from Main Pool) " +
      "+ UnclaimedAIA_FYA (Unclaimed FYA and AIA amounts)) - CATO-2730" in new TestFixture {
      withBox(CP78(Some(2000)))
      withBox(CP79(Some(20)))
      withBox(CP80(Some(30)))
      withBox(CP82(Some(2000)))
      withBox(CP83(Some(50)))
      withBox(CP87Input(Some(50)))
      withBox(CP672(Some(1000)))
      withBox(CPAux1(0))
      withBox(CPAux2(0))
      withBox(CATO21(18))

      CP89(549).validate(computationsBoxRetriever) shouldBe Set()
      CP89(550).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP89"), errorMessageKey = "error.CP89.mainPoolAllowanceExceeded", Some(Seq("549"))))
    }

    "validates when greater than MAX(0, MainPool% * ( CP78 (Main Pool brought forward) " +
      "+ CP82 (Additions Qualifying for Main Pool) + MainRatePool - CP672 (Proceed from Disposals from Main Pool) " +
      "+ LEC14 (Unclaimed FYA and AIA amounts)))" in new TestFixture {
      withBox(CP78(Some(100)))
      withBox(CP82(Some(100)))
      withBox(CP672(Some(100)))
      withBox(CPAux2(50))
      withBox(CATO21(10))
      withBox(CATO22(50))

      CP89(15).validate(computationsBoxRetriever) shouldBe Set()
      CP89(16).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP89"), errorMessageKey = "error.CP89.mainPoolAllowanceExceeded", Some(Seq("15"))))
    }

    "validated when CP672 is large enough to make the total -ve and any +ve claim is made" in new TestFixture {
      withBox(CP78(Some(100)))
      withBox(CP82(Some(100)))
      withBox(CP672(Some(1000)))
      withBox(CPAux2(100))
      withBox(CATO21(10))

      CP89(0).validate(computationsBoxRetriever) shouldBe Set()
      CP89(1).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP89"), errorMessageKey = "error.CP89.mainPoolAllowanceExceeded", Some(Seq("0"))))
    }

    "validate when ceased trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(true)))

      CP89(None).validate(computationsBoxRetriever) shouldBe Set()
    }

    "validate when ceased trading not set" in new TestFixture {
      CP89(None).validate(computationsBoxRetriever) shouldBe Set()
    }

    "fails validation when negative" in new TestFixture {
      withBox(CPQ8(Some(false)))

      CP89(-1).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP89"), errorMessageKey = "error.CP89.mustBeZeroOrPositive"))
    }
  }

  "(CP668) Writing Down Allowance claimed from Special rate pool" should {
    "validates correctly when not greater than MAX( 0, SpecialPool% * ( CP666 + CPaux3 - CP667) )" in new TestFixture {
      withBox(CP666(Some(100)))
      withBox(CP667(100))
      withBox(CPAux3(100))
      withBox(CATO22(10))

      CP668(10).validate(computationsBoxRetriever) shouldBe Set()
      CP668(11).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP668"), errorMessageKey = "error.CP668.specialRatePoolAllowanceExceeded", Some(Seq("10"))))
    }

    "fails validation when CP667 is large enough to make the total -ve and any +ve claim is made" in new TestFixture {
      withBox(CP666(Some(100)))
      withBox(CP667(1000))
      withBox(CPAux3(100))
      withBox(CATO22(10))

      CP668(0).validate(computationsBoxRetriever) shouldBe Set()
      CP668(1).validate(computationsBoxRetriever) shouldBe Set(CtValidation(boxId = Some("CP668"), errorMessageKey = "error.CP668.specialRatePoolAllowanceExceeded", Some(Seq("0"))))
    }

    "validate when ceased trading but no value entered" in new TestFixture {
      withBox(CPQ8(Some(true)))

      CP668(None).validate(computationsBoxRetriever) shouldBe Set()
    }
    "validate when ceased trading not set" in new TestFixture {
      CP668(None).validate(computationsBoxRetriever) shouldBe Set()
    }
  }
}
