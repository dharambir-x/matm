import Foundation

@objc public class veer: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
