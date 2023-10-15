# Calico React Example

Temporary project to demonstrate a minimal calico with React - this should be moved elsewhere. Note: getting familiar with Scala 3, so some of the syntax is Scala 2.13.

Install npm dependencies:
1. `nix-shell -p nodejs`
2. `cd web`
3. `npm install`
4. `cp -r node_modules ..` [reference](https://github.com/scala-js/vite-plugin-scalajs/issues/13)

Following this:
- On a new terminal: `sbt "~fastLinkJS"` to monitor file changes and build the `scalajs:main.js` file.
- On the original terminal: `npm run dev` to serve linked webpage locally.

## Issues

- Several warnings related to multiple missing source files. They are likely related with [something I dont fully understand yet](https://github.com/scala-js/vite-plugin-scalajs/issues/13).

- Slinky dependency.

# Helpful pages

Reference pages:
- https://www.scala-js.org/doc/interoperability/facade-types.html
- https://react.dev/reference/react-dom/client/createRoot#rendering-a-page-partially-built-with-react
- https://github.com/armanbilge/calico
- https://codesandbox.io/s/n3w687vmqj?file=/index.js
- https://codesandbox.io/s/github/airbnb/visx/tree/master/packages/visx-demo/src/sandboxes/visx-tree?file=/Example.tsx
