package com.example.TaxCalculaterMicroservice2.controller

import com.example.TaxCalculaterMicroservice2.model.Employee
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employeeTax")
class TaxCalcuaterController(employeeTax: Employee?) {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/{employeeSalary}")
    fun getTaxDetails(@PathVariable employeeSalary: String?): Employee? {
        log.info("Entered into taxcaluator class to get the tax and netsalry details::")
        var employeeTax = 0.0
        val salary = (employeeSalary!!.toDouble()) * 12
        if (salary < 25000) {
            employeeTax = salary * 0.10
        } else if (salary < 45000) {
            employeeTax = salary * 0.20
        } else if (salary < 65000) {
            employeeTax = salary * 0.25
        } else if (salary < 85000) {
            employeeTax = salary * 0.30
        } else if (salary > 85000) {
            employeeTax = salary * 0.35
        }
        var netSalary = salary - employeeTax
        log.info("taxAmount:::$employeeTax")
        log.info("netSalary:::$netSalary")

        return Employee(employeeTax.toString(), netSalary.toString())
    }
}
