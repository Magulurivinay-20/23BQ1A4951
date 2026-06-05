package com.vinay.vehiclemaintenancescheduler.service;

import com.vinay.vehiclemaintenancescheduler.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerService {

    public List<Vehicle> getOptimalTasks(
            List<Vehicle> vehicles,
            int mechanicHours) {

        int n = vehicles.size();

        int[][] dp = new int[n + 1][mechanicHours + 1];

        for (int i = 1; i <= n; i++) {

            Vehicle vehicle = vehicles.get(i - 1);

            for (int w = 0; w <= mechanicHours; w++) {

                if (vehicle.getDuration() <= w) {

                    dp[i][w] = Math.max(
                            vehicle.getImpact()
                                    + dp[i - 1][w - vehicle.getDuration()],
                            dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        List<Vehicle> selected = new ArrayList<>();

        int w = mechanicHours;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                Vehicle vehicle = vehicles.get(i - 1);

                selected.add(vehicle);

                w -= vehicle.getDuration();
            }
        }

        return selected;
    }
}