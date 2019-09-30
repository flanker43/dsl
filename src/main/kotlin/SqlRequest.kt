import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.handlers.BeanListHandler
import org.postgresql.ds.PGSimpleDataSource

object SqlRequest {
    val DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres"
    val USER = "postgres"
    val PASS = "password"

    inline fun <reified T> QueryRunner.findOne(sql: String) =
        BeanHandler(T::class.java).run { query(sql, this) }


    inline fun <reified T> QueryRunner.findAll(sql: String): MutableList<T> {
        return BeanListHandler(T::class.java).run { query(sql, this) }
    }

    inline fun <reified T> QueryRunner.upd(sql: String) = update(sql)

//    fun ds() {
//        val ds = PGSimpleDataSource()
//        ds.setURL(DB_URL)
//        ds.user = USER
//        ds.password = PASS
//
//        return ds()
//    }

    fun sqlReq(sql: String) {
//        val ds = ds()
        val ds = PGSimpleDataSource()
        ds.setURL(DB_URL)
        ds.user = USER
        ds.password = PASS
        var runner = QueryRunner(ds)
        val user = runner.findOne<UsersDto>(sql)
    }

    fun sqlReqB(sql: String) {
        val ds = PGSimpleDataSource()
        ds.setURL(DB_URL)
        ds.user = USER
        ds.password = PASS

        var runner = QueryRunner(ds)
        val user = runner.upd<UsersDto>(sql)
    }
}