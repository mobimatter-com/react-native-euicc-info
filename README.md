# react-native-euicc-info

Simple eUICC info for Android. Contains only one function that returns the OS version of the eUICC chip. When eUICC is unavailable, the method returns null.

*This pacakge is Android only and does not support iOS, web or Windows*

## Installation

```sh
npm install react-native-euicc-info
```

## Usage

```js
import { getEuiccVersion } from 'react-native-euicc-info';

// ...

const result = await getEuiccVersion(); // Android only

if(!result) {
    // eUICC chip is not available
}
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
