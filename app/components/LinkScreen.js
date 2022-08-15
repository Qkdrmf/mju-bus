/* eslint-disable react/prop-types */
import { useNavigation } from "@react-navigation/native";
import React from "react";
import { TouchableOpacity, Dimensions, View } from "react-native";
import styled from "styled-components/native";
import { Entypo, FontAwesome } from "@expo/vector-icons";

const { width: SCREEN_WIDTH } = Dimensions.get("window");

const Board = styled.View`
  width: 90%;
  height: 100px;
  background-color: white;
  padding: 10px ${SCREEN_WIDTH * 0.08}px;
  border-radius: 20px;
  flex-direction: row;
  align-items: center;
  margin-bottom: 10px;
`;

const Column = styled.View`
  flex: 3;
`;

const Title = styled.Text`
  font-family: "SpoqaHanSansNeo-Bold";
  font-size: 20px;
  color: black;
`;

const SubText = styled.Text`
  font-family: "SpoqaHanSansNeo-Medium";
  font-size: ${SCREEN_WIDTH > 500 ? 16 : 13}px;
  color: gray;
  margin-bottom: 7px;
`;

function LinkScreen({ screenName }) {
  const navigation = useNavigation();
  const goToSchedule = () => {
    navigation.navigate("HomeBottomTabs", {
      screen: `${screenName}`,
      params: {},
    });
  };

  return (
    <TouchableOpacity onPress={goToSchedule} style={{}}>
      <Board>
        <FontAwesome
          name={screenName === "시간표" ? "calendar-o" : "bus"}
          size={30}
          color="black"
          style={{ flex: 1 }}
        />

        <Column>
          <SubText>
            {screenName === "시간표"
              ? "현재 운영 중인 시간표에요"
              : "가장 빠른 셔틀버스를 탐색해요"}
          </SubText>
          <Title>
            {screenName === "시간표" ? "버스 시간표 보기" : "버스 검색하기"}
          </Title>
        </Column>
        <View
          style={{
            flex: 1,
            alignItems: "flex-end",
          }}
        >
          <Entypo name="chevron-right" size={20} color="gray" />
        </View>
      </Board>
    </TouchableOpacity>
  );
}
export default LinkScreen;
