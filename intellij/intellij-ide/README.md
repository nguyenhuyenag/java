# IntelliJ

- Phím tắt Eclipse & IntelliJ: https://www.cloudflight.io/en/blog/intellij-idea-and-eclipse-shortcuts/

- Bảng gõ tắt: Setting > Keymap

- Phím tắt
    
	- sou/sout/soutv  + tab					System.out.println();
	
	- ps..									public static
	
		psvm								Tạo hàm main()
    
	- fori
    
	- Ctrl + J                				Mở bảng gõ tắt
	
	- Ctrl + F                				Tìm kiếm
	
	- Alt + Enter (khối code)				Tạo import static
	
	- Shift + Alt + Up/Down    				Move code up/down
    
	- Ctrl + Alt + O          				Xóa các import không sử dụng
	
	- Ctrl + Alt + L          				Format code
	
	  Ctrl + Alt + Shift + L   				Format code 
	
	- Ctrl + Alt + V						Tạo biến cục bộ 
	
	- Ctrl + Alt + F						Tạo biến global (nằm ngoài method)
	
	- Ctrl + Shift + N						Find file / open resource
	
- Open project

	+ Cửa sổ hiện tại: 	File > New > Module from Existing...
	
	+ Cửa sổ mới: 		File > New > project from Existing Sources...

- Tắt kiểm tra chính tả

	Preferences > Settings > Editor > Inspections > Proofreading > typo (uncheck)

- Xóa <p> khi format code

	Settings > Editor > Code Style > Java
	
			 > JavaDoc tab, and then uncheck Generate "<p>" on empty lines

- Ẩn đường dẫn của project trong 'Project'

	+ Link: https://stackoverflow.com/a/40909474
	
	+ Main Menu > Help > Edit Custom Properties... | Thêm vào 
	
		project.tree.structure.show.url=false
