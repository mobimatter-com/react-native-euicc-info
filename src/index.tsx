import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-euicc-info' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const EuiccInfo = NativeModules.EuiccInfo
  ? NativeModules.EuiccInfo
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export async function getEuiccVersion(): Promise<any> {
  if (Platform.OS === 'android') {
    return await EuiccInfo.getEuiccVersion();
  }

  return null;
}
