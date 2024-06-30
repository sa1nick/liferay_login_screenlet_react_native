import React from 'react';
import {requireNativeComponent, ViewProps} from 'react-native';

const CustomNativeView = requireNativeComponent('CustomNativeView');

const MyCustomNativeView: React.FC<ViewProps> = props => {
  return <CustomNativeView {...props} />;
};

export default MyCustomNativeView;
