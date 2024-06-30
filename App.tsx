import React from 'react';
import {SafeAreaView, StyleSheet} from 'react-native';
import MyCustomNativeView from './CustomNativeView';

const App = () => {
  return (
    <SafeAreaView style={styles.container}>
      <MyCustomNativeView style={styles.nativeView} />
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  nativeView: {
    width: '100%',
    height: '100%',
  },
});

export default App;
