import type { CapacitorConfig } from '@capacitor/cli'

const config: CapacitorConfig = {
  appId: 'com.drleng.medphoto',
  appName: '术影档案',
  webDir: 'dist',
  android: {
    allowMixedContent: false,
  },
}

export default config
