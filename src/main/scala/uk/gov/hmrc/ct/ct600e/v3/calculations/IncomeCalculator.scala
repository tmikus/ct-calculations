package uk.gov.hmrc.ct.ct600e.v3.calculations

import uk.gov.hmrc.ct.ct600e.v3._

trait IncomeCalculator {

  def calculateTotalIncome(e50: E50, e55: E55, e60: E60, e65: E65, e70: E70, e75: E75, e80: E80, e85: E85): E90 = {
    E90(None)
  }
}