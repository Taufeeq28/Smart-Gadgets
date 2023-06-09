var productChart = {
  
/*return google visualization data*/
  getvisualizationData : function(jsonData){
  
   var   totalSales, dataArray = [],
   
       data = new google.visualization.DataTable();
       
       data.addColumn('string', 'Product');
       data.addColumn('number', 'Sales');
        $.each(jsonData, function(i,obj){
          
          totalSales ="Quantity : "+ obj.quantity +"";
          
          dataArray.push([obj.modelName,parseInt(obj.totalSales)]);
        });
        
       data.addRows(dataArray);
       
       return data;
  },
  /*return options for bar chart: these options are for various configuration of chart*/
  getOptionForBarchart : function(){
    
      var options = {
          
          title: 'Product Sales Report',
            animation:{
                   duration: 2000,
                   easing: 'out'
              },
              
                hAxis: {
                    baselineColor: '#ccc',
              title: 'Product Name'
                },
                vAxis: {
              title: 'Total Sales',
                    baselineColor: '#ccc',
                    gridlineColor: '#fff'
                },
      
               // isStacked: true,
                height: 400,
                backgroundColor: '#fff',
                colors: ["#68130E", "#c65533"],
                fontName: 'roboto',
                fontSize: 12,
                legend: {
                    position: 'top',
                    alignment: 'end',
                    textStyle: {
                        color: '#b3b8bc',
                        fontName: 'roboto',
                        fontSize: 12
                    }
                },
                tooltip: {
                    isHtml: true,
                    showColorCode: true,
                    isStacked: true
                }
           };
    return   options;    
    },
  /*Draws a Bar chart*/ 
  drawBarChart : function (inputdata) {

     var  barOptions = productChart.getOptionForBarchart(),
    
        data = productChart.getvisualizationData(inputdata),
        
        chart = new google.visualization.ColumnChart(document.getElementById('product-totalsales-bar-chart'));
        
        chart.draw(data, barOptions);
        /*for redrawing the bar chart on window resize*/
        $(window).resize(function () {
          
            chart.draw(data, barOptions);
        });
   },
  /* Returns a custom HTML tooltip for Visualization chart*/
   returnTooltip : function(dataPoint1){
     
     return "<div style='height:30px;width:150px;font:12px,roboto;padding:15px 5px 5px 5px;border-radius:3px;'>"+
         "<span style='color:#68130E;font:12px,roboto;padding-right:20px;'>"+dataPoint1+"</span>"+
         //"<span style='color:#c65533;font:12px,roboto;'>"+dataPoint2+"</span>"+
         "</div>";
   },
  /*Makes ajax call to servlet and download data */
  getProductData : function(){
      $.ajax({
        type: "POST",
        
        url: "googlevisualization",
        
        dataType: "JSON",
        
        success: function(data){
  
          productChart.drawBarChart(data);
        }
      });
  }
};  

google.load("visualization", "1", {packages:["corechart"]});
  
$(document).ready(function(){
  productChart.getProductData();
});

