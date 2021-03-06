// Code generated by Node.js script
package app.himawari.dto.json

enum class VacationType(val description: String) {
    PAID_DAY_OFF("有給休暇"),
    SP_DAY_OFF("特別休暇"),
    AM_OFF("AM休"),
    PM_OFF("PM休"),
    TRANSFER_DAY_OFF("振替休暇")
}

enum class ResultType(val description: String) {
    success(""),
    failure("")
}