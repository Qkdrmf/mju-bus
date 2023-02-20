import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { ThemeProvider } from "styled-components/native";
import { useColorScheme } from "react-native";
import CodePush from "react-native-code-push";
import Root from "./navigation/Root";
import { darkTheme, lightTheme } from "./styled";
import useCodePush from "./hooks";
import SyncProgressView from "./screens/SyncProgressView";
import AuthProvider from "./components/AuthProvider";
import AsyncStorage from "@react-native-async-storage/async-storage";

const queryClient = new QueryClient();

function App() {
  const isDark = useColorScheme() === "dark";
  const [isUpdating, syncProgress] = useCodePush();

  return (
    <QueryClientProvider client={queryClient}>
      <ThemeProvider theme={isDark ? darkTheme : lightTheme}>
        {isUpdating ? (
          <SyncProgressView syncProgress={syncProgress} />
        ) : (
          <NavigationContainer>
            <AuthProvider>
              <Root />
            </AuthProvider>
          </NavigationContainer>
        )}
      </ThemeProvider>
    </QueryClientProvider>
  );
}

export default CodePush(App);
