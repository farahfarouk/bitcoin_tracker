package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javafx.application.Application.launch;

public class Controller {

    BTC my_price;
    @FXML // fx:id="price_label";
            Label price_label;

    High  highprice;
    @FXML // fx:id="high_label";
            Label high_label;


    Low lowprice;
    @FXML // fx:id="low_price"
            Label low_label;

    VolumeFrom vfrom;
    @FXML // fx:id="vfrom_label"
            Label vfrom_label;

    VolumeTo vto;
    @FXML // fx:id="vto_label"
            Label vto_label;

    @FXML // fx:id="chart";
            LineChart<String, Double> line_chart;

    High  highprice1;
    @FXML // fx:id="high_label";
            Label high_label1;


    Low lowprice1;
    @FXML // fx:id="low_price"
            Label low_label1;


    BTC time;
    @FXML // fx:id="BTC_time"
            Label BTC_time;


    ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    public Controller(){
        my_price = new BTC();

        highprice = new High();

        lowprice = new Low();

        highprice1 = new High();

        lowprice1 = new Low();

        vfrom = new VolumeFrom();

        vto = new VolumeTo();

        time = new BTC();


        Controller ctrl = this;

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ctrl.refreshCurrency();


            }
        }, 0, 1, TimeUnit.MINUTES);

        Controller ctrlHour = this;
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ctrlHour.refreshCurrencyHour();



            }
        }, 0, 1, TimeUnit.HOURS);

        Controller ctrlDay = this;
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ctrlDay.refreshCurrencyDay();



            }
        }, 0, 1, TimeUnit.DAYS);
    }


    public void refreshCurrency() {
        System.out.println("Refreshing MINUTES...");


        CompletableFuture<Double> future = new CompletableFuture<Double>();

      /* future.supplyAsync(() -> {
          time.getTimeMin();
            Platform.runLater(() -> {
                BTC_time.setText(new Double(time.time).toString());
            });

            return 1.0;
        });*/

        future.supplyAsync(() -> {
            my_price.getCurrency();
            Platform.runLater(() -> {
                price_label.setText(new Double(my_price.price).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            highprice.getHigh();
            Platform.runLater(() -> {
                high_label.setText(new Double(highprice.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice.getLow();
            Platform.runLater(() -> {
                low_label.setText(new Double(lowprice.lowprice).toString());
            });

            return 1.0;
        });
        future.supplyAsync(() -> {
            highprice1.getHigh();
            Platform.runLater(() -> {
                high_label1.setText(new Double(highprice1.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice1.getLow();
            Platform.runLater(() -> {
                low_label1.setText(new Double(lowprice1.lowprice).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            vfrom.getVfrom();
            Platform.runLater(() -> {
                vfrom_label.setText(new Double(vfrom.vfrom).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            vto.getVto();
            Platform.runLater(() -> {
                vto_label.setText(new Double(vto.vto).toString());
            });

            return 1.0;
        });
    }


    public void refreshCurrencyHour() {
        System.out.println("Refreshing HOURS...");

        CompletableFuture<Double> future = new CompletableFuture<Double>();

      /*  future.supplyAsync(() -> {
            BTCtimeHour.getTimeHour();
            Platform.runLater(() -> {
                BTC_timehour.setText(new Double(BTCtimeHour.BTCtimeHour).toString());
            });

            return 1.0;
        });*/

        future.supplyAsync(() -> {
            my_price.getCurrencyHour();
            Platform.runLater(() -> {
                price_label.setText(new Double(my_price.price).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            highprice.getHighHour();
            Platform.runLater(() -> {
                high_label.setText(new Double(highprice.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice.getLowHour();
            Platform.runLater(() -> {
                low_label.setText(new Double(lowprice.lowprice).toString());
            });

            return 1.0;
        });
        future.supplyAsync(() -> {
            highprice1.getHighHour();
            Platform.runLater(() -> {
                high_label1.setText(new Double(highprice1.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice1.getLowHour();
            Platform.runLater(() -> {
                low_label1.setText(new Double(lowprice1.lowprice).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            vfrom.getVfromHour();
            Platform.runLater(() -> {
                vfrom_label.setText(new Double(vfrom.vfrom).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            vto.getVtoHour();
            Platform.runLater(() -> {
                vto_label.setText(new Double(vto.vto).toString());
            });

            return 1.0;
        });
    }

    public void refreshCurrencyDay() {
        System.out.println("Refreshing DAYS...");

        CompletableFuture<Double> future = new CompletableFuture<Double>();

      /*  future.supplyAsync(() -> {
            BTCtimeDay.getTimeDay();
            Platform.runLater(() -> {
                BTC_timeday.setText(new Double(BTCtimeDay.BTCtimeDay).toString());
            });

            return 1.0;
        });*/

        future.supplyAsync(() -> {
            my_price.getCurrencyDay();
            Platform.runLater(() -> {
                price_label.setText(new Double(my_price.price).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            highprice.getHighDay();
            Platform.runLater(() -> {
                high_label.setText(new Double(highprice.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice.getLowDay();
            Platform.runLater(() -> {
                low_label.setText(new Double(lowprice.lowprice).toString());
            });

            return 1.0;
        });
        future.supplyAsync(() -> {
            highprice1.getHighDay();
            Platform.runLater(() -> {
                high_label1.setText(new Double(highprice1.highprice).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            lowprice1.getLowDay();
            Platform.runLater(() -> {
                low_label1.setText(new Double(lowprice1.lowprice).toString());
            });

            return 1.0;
        });


        future.supplyAsync(() -> {
            vfrom.getVfromDay();
            Platform.runLater(() -> {
                vfrom_label.setText(new Double(vfrom.vfrom).toString());
            });

            return 1.0;
        });

        future.supplyAsync(() -> {
            vto.getVtoDay();
            Platform.runLater(() -> {
                vto_label.setText(new Double(vto.vto).toString());
            });

            return 1.0;
        });
    }


    public void loadChart() {

        XYChart.Series series = new XYChart.Series();

        series.setName("BTC PRICE");


        Date date = new Date(((long) time.time)*1000L);
         DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("PST"));
       String formatted = format.format(date);
      System.out.println(formatted);

        series.getData().add(new XYChart.Data(formatted, my_price.price));



        line_chart.getData().add(series);


        line_chart.getXAxis().setLabel("Time");
        line_chart.getYAxis().setLabel("Price");

    }

}






