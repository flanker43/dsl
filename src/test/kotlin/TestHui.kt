import SqlExpressions.delete
import org.junit.Test
import SqlExpressions.insert
import SqlExpressions.values
import SqlExpressions.where

class TestHui {

    @Test
    fun testsqlReq(){
       SqlRequest.sqlReqB(delete("DSL.company").where("id=12"))

    }
}