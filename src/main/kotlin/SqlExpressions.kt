object SqlExpressions {
    fun select(vararg param: String): String {
        return if (param.isNotEmpty()) {
            "SELECT " + param.joinToString()
        } else {
            "SELECT *"
        }
    }

    fun delete(param: String): String = "DELETE FROM $param "

    fun update(tablename: String): String = "UPDATE $tablename "

    fun insert(tablename: String): String = "INSERT INTO $tablename "


    infix fun String.on(param: String): String = this + " ON " + param

    infix fun String.innerJoin(param: String): String = this + " INNER JOIN " + param

    infix fun String.join(param: String): String = this + " JOIN " + param

    infix fun String.add(param: String): String = this + "ADD " + param

    infix fun String.to(param: String): String = this + "TO " + param

    infix fun String.renameTo(param: String): String = this + "RENAME TO " + param

    infix fun String.dropColumn(param: String): String = this + "DROP COLUMN " + param

    infix fun String.modify(param: String): String = this + "MODIFY " + param

    infix fun String.values(param: String) = this + "VALUES " + "('" + param + "')"

    infix fun String.set(param: String) = this + "SET " + param

    infix fun String.from(tablename: String) = this + " FROM " + tablename

    infix fun String.where(param: String) = this + " WHERE " + param

    infix fun String.orderBy(param: String) = this + " ORDER BY " + param

    infix fun String.groupBy(param: String) = this + " GROUP BY " + param

    infix fun String.having(param: String) = this + " HAVING " + param
}