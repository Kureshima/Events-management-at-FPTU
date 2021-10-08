USE [FPTEventManagement]
GO
/****** Object:  Table [dbo].[tblPosts]    Script Date: 10/8/2021 7:07:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPosts](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[postId]  AS ('P'+right(CONVERT([varchar](3),[ID]),(3))) PERSISTED NOT NULL,
	[userId] [nvarchar](50) NULL,
	[title] [nvarchar](50) NULL,
	[content] [nvarchar](300) NULL,
	[video] [nvarchar](100) NULL,
	[createDate] [datetime] NOT NULL,
	[statusId] [nvarchar](5) NULL,
 CONSTRAINT [tblContents] PRIMARY KEY CLUSTERED 
(
	[postId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblStatusPost]    Script Date: 10/8/2021 7:07:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblStatusPost](
	[statusId] [nvarchar](5) NOT NULL,
	[statusName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[statusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tblPosts] ON 

INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (0, N'102340646113497938153', N'post1', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (1, N'102340646113497938153', N'post2', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (2, N'102340646113497938153', N'post3', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (3, N'102340646113497938153', N'post4', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (4, N'102340646113497938153', N'post5', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (5, N'102340646113497938153', N'post6', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (6, N'102340646113497938153', N'post7', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (7, N'102340646113497938153', N'post8', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (8, N'102340646113497938153', N'post9', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[tblPosts] ([ID], [userId], [title], [content], [video], [createDate], [statusId]) VALUES (9, N'102340646113497938153', N'post10', N'.NET', N'https://www.youtube.com/watch?v=AlXfbVpDUdo&list=RDAlXfbVpDUdo&start_radio=1', CAST(N'2021-10-08T00:00:00.000' AS DateTime), N'A')
SET IDENTITY_INSERT [dbo].[tblPosts] OFF
GO
INSERT [dbo].[tblStatusPost] ([statusId], [statusName]) VALUES (N'A', N'Active')
INSERT [dbo].[tblStatusPost] ([statusId], [statusName]) VALUES (N'D', N'Deactive')
GO
ALTER TABLE [dbo].[tblPosts]  WITH CHECK ADD FOREIGN KEY([statusId])
REFERENCES [dbo].[tblStatusPost] ([statusId])
GO
ALTER TABLE [dbo].[tblPosts]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[tblUsers] ([userId])
GO
