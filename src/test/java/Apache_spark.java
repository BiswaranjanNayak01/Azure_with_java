import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;
import java.util.List;

public class Apache_spark {

//    youtube --- https://www.youtube.com/watch?v=gHAFeKGCRV8&list=PLm3O9IUTfMrcqsAjjxRSpj79unJPYyEhq&index=2

    //    Creating a DataFrame from a list of data:
    SparkSession spark = SparkSession.builder().getOrCreate();

    StructType schema = DataTypes.createStructType(new StructField[]{
            DataTypes.createStructField("name", DataTypes.StringType, false),
            DataTypes.createStructField("age", DataTypes.IntegerType, false)
    });

    List<Row> data = Arrays.asList(
            RowFactory.create("Alice", 25),
            RowFactory.create("Bob", 30)
    );

    Dataset<Row> df = spark.createDataFrame(data, schema);

    //    Reading data from a CSV file:
//    df = spark.read().option("header", true).option("inferSchema", true).csv("path/to/file.csv");

}