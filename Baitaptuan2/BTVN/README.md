# Ứng dụng Thực hành 01 - Kiểm tra độ tuổi

## Mô tả
Ứng dụng Android đơn giản để nhập thông tin cá nhân (họ tên và tuổi) và phân loại người dùng theo độ tuổi.

## Tính năng
- Nhập họ và tên
- Nhập tuổi
- Kiểm tra và phân loại theo độ tuổi:
  - **Em bé**: ≤2 tuổi
  - **Trẻ em**: 2-6 tuổi  
  - **Người lớn**: 6-65 tuổi
  - **Người già**: >65 tuổi

## Cách sử dụng
1. Mở ứng dụng
2. Nhập họ và tên vào ô "Họ và tên"
3. Nhập tuổi vào ô "Tuổi"
4. Nhấn nút "Kiểm tra"
5. Xem kết quả hiển thị bên dưới

## Cách chạy ứng dụng
1. Mở Android Studio
2. Mở project này
3. Đảm bảo có thiết bị Android hoặc emulator đang chạy
4. Nhấn nút "Run" (Ctrl+R) hoặc chọn Run > Run 'app'

## Cấu trúc dự án
- `MainActivity.kt`: Logic chính của ứng dụng
- `activity_main.xml`: Giao diện người dùng
- `strings.xml`: Chuỗi văn bản

## Validation
Ứng dụng có các kiểm tra:
- Không được để trống họ tên
- Không được để trống tuổi
- Tuổi phải là số
- Tuổi phải trong khoảng hợp lệ (0-150)

## Giao diện
Giao diện được thiết kế đơn giản với:
- Tiêu đề "THỰC HÀNH 01"
- Form nhập liệu với nền xám
- Nút "Kiểm tra" màu xanh
- Khu vực hiển thị kết quả
