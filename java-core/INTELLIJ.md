# IntelliJ

- Phím tắt Eclipse & IntelliJ: https://www.cloudflight.io/en/blog/intellij-idea-and-eclipse-shortcuts/

- IMPORTANT: Một số project khi mở nó ở trong 1 project có thể sẽ gây lỗi FileNotFound:

	+ Ví dụ mở project spring-boot-mvc ở một workspace khác lỗi do không tìm được [/WEB-INF/tiles.xml]

- Show main menu

	+ Ctrl + Shift + A > Tìm kiếm 'Main Menu' trong Actions

- Bảng gõ tắt: Setting > Keymap

- Phím tắt
    
	- sou/sout/soutv  + tab					System.out.println();
	
	- ps..									public static
	
		main, psvm							Tạo hàm main()

    - fori									Tạo nhanh vòng lặp for
	
	- F3									Search
    
	- Ctrl + J                				Mở bảng gõ tắt
	
	- Ctrl + F                				Tìm kiếm
	
	- Ctrl + Numpad (+, -)                	Thu gọn long text hoặc method	
	
	- Alt + Enter (khối code)				Tạo import static
	
	- Alt + 1								Tắt project view bên trái
	
	- Alt + Insert							Mở bảng generate (tạo getter, setter,...)
	
	- Shift + Alt + Up/Down    				Move code up/down
	
	- Ctrl + Alt + B          				Mở nhanh 1 hàm
    
	- Ctrl + Alt + O          				Xóa các import không sử dụng
	
	- Ctrl + Alt + L          				Format code
	
	  Ctrl + Alt + Shift + L   				Format code 
	
	- Ctrl + Alt + V						Tạo biến cục bộ 
	
	- Ctrl + Alt + F						Tạo biến global (nằm ngoài method)
	
	- Ctrl + Shift + N						Find file / open resource

	- Ctrl + Tab (nhấn giữ) 				Chuyển đổi giữa các tab
	
- Open project

	+ Cửa sổ hiện tại: 	File > New > Module from Existing...
	
	+ Cửa sổ mới: 		File > New > project from Existing Sources...

- Tắt kiểm tra chính tả

	Preferences > Settings > Editor > Inspections > Proofreading > typo (uncheck)

- Xóa <p> khi format code

	Settings > Editor > Code Style > Java > JavaDoc > Generate "<p>" on empty lines

- Ẩn đường dẫn của project trong 'Project'

	+ Link: https://stackoverflow.com/a/40909474
	
	+ Main Menu > Help > Edit Custom Properties... | Thêm vào 
	
		project.tree.structure.show.url=false

- Ẩn thư mục trong Project View

	+ Click phải vào thư mục > Make Directory as > Excluded

- Ẩn file / thư mục trong project view

	+ File > Settings > Editor > File Types > Ignored Files & Folders

	  Ví dụ `*.settings` chẳng hạn

- Live Templates (tạo nhanh hàm, vòng lặp,...)

	+ Settings > Editor > Live Templates > ... 
			
	  Chọn thêm Applicable in Java... trước khi hoàn thành

- Run devtools
	
  	+ Settings > Advanced Settings > Allow auto-make to start ...
  
             >   Build, Execution... > Compiler > Build project auto...

- File encoding
	
	+ Setting > Editor > File Encoding

- Environment variables

	+ Run | Edit Configurations > Modify options -> Choose Environment Variables > Edit ...

		KEY		:	  Value
	
		${KEY}
    
