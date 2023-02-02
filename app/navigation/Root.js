import React from "react";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import HomeBottomTabs from "./HomeBottomTabs";
import Splash from "../screens/Splash";
import SearchStack from "./SearchStack";
import NoticeStack from "./NoticeStack";
import AddPartyStack from "./AddPartyStack";
import Taxi_nmap from './../screens/Taxi/Taxi_nmap';
import Taxi_start from "../screens/Taxi/Taxi_start";
import Taxi_destination from "../screens/Taxi/Taxi_destination";

const Nav = createNativeStackNavigator();

function Root() {
  return (
    <Nav.Navigator
      initialRouteName="Splash"
      screenOptions={{
        headerShown: false,
      }}
    >
      <Nav.Screen name="Splash" component={Splash} />
      <Nav.Screen
        name="HomeBottomTabs"
        component={HomeBottomTabs}
        options={{ gestureEnabled: false }}
      />
      <Nav.Screen
        name="SearchStack"
        component={SearchStack}
        options={{ headerShown: false }}
      />

      <Nav.Screen name="NoticeStack" component={NoticeStack} />
      <Nav.Screen name="AddPartyStack" component={AddPartyStack}/>
      <Nav.Screen name="Taxi_nmap" component={Taxi_nmap}/>
      <Nav.Screen name="Taxi_start" component={Taxi_start}/>
      <Nav.Screen name="Taxi_destination" component={Taxi_destination}/>
    </Nav.Navigator>
  );
}

export default Root;
