import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { LiveStreamView } from 'react-native-live_stream';

export default function App() {
  return (
    <View style={styles.container}>
      <LiveStreamView color="#32a852" style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 100,
    height: 100,
    marginVertical: 20,
  },
});
