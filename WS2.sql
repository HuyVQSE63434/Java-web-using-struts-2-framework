/****** Object:  Database [WorkShop1 ]    Script Date: 6/21/2018 11:41:57 AM ******/
CREATE DATABASE [WorkShop1 ]

ALTER DATABASE [WorkShop1 ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WorkShop1 ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WorkShop1 ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WorkShop1 ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WorkShop1 ] SET ARITHABORT OFF 
GO
ALTER DATABASE [WorkShop1 ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WorkShop1 ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WorkShop1 ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WorkShop1 ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WorkShop1 ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WorkShop1 ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WorkShop1 ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WorkShop1 ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WorkShop1 ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WorkShop1 ] SET  DISABLE_BROKER 
GO
ALTER DATABASE [WorkShop1 ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WorkShop1 ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WorkShop1 ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WorkShop1 ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WorkShop1 ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WorkShop1 ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WorkShop1 ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WorkShop1 ] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [WorkShop1 ] SET  MULTI_USER 
GO
ALTER DATABASE [WorkShop1 ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WorkShop1 ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WorkShop1 ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WorkShop1 ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [WorkShop1 ] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [WorkShop1 ] SET QUERY_STORE = OFF
GO
USE [WorkShop1 ]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [WorkShop1 ]
GO
/****** Object:  User [Huy]    Script Date: 6/21/2018 11:41:58 AM ******/
CREATE USER [Huy] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[tbl_Cart]    Script Date: 6/21/2018 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Cart](
	[customerId] [varchar](10) NOT NULL,
	[productId] [varchar](10) NOT NULL,
	[productName] [varchar](20) NULL,
	[quantity] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Mobile]    Script Date: 6/21/2018 11:41:58 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Mobile](
	[mobileId] [varchar](10) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[price] [float] NULL,
	[mobileName] [varchar](20) NOT NULL,
	[yearOfProduction] [int] NULL,
	[quantity] [int] NULL,
	[notSale] [bit] NULL,
 CONSTRAINT [PK_tbl_Mobile] PRIMARY KEY CLUSTERED 
(
	[mobileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 6/21/2018 11:41:59 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[userID] [nchar](10) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [varchar](50) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb001', N'dien thoai cam ung', 4300000, N'LG g5', 2013, 4, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb002', N'dien thoai cam ung', 2300000, N'mobileStar', 2010, 3, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb003', N'dien thoai trang den', 450000, N'nokia1080', 2005, 9, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb004', N'dien thoai nap gap', 1200000, N'motorola500', 2004, 10, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb005', N'dien thoai nap truot', 1500000, N'nokia5670', 2004, 12, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb006', N'dien thoai thong minh', 9600000, N'bphone2', 2017, 12, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'mb007', N'dien thoai sieu nhan', 2300000, N'Asus Gamingphone', 2018, 13, 1)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'I001      ', 123123, N'Vu Quang Huy', 0)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'I002      ', 234234, N'Nguyen Quoc Chuong', 0)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'I003      ', 345345, N'Dinh Thien Duc', 2)
INSERT [dbo].[tbl_User] ([userID], [password], [fullName], [role]) VALUES (N'I005      ', 567567, N'Bui Duc Cuong', 0)
USE [master]
GO
ALTER DATABASE [WorkShop1 ] SET  READ_WRITE 
GO
