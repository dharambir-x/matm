export interface veerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
