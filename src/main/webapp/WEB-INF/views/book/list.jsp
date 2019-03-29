<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>
<%@ taglib prefix = "ara" tagdir = "/WEB-INF/tags" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">List of books in my library</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- /.row -->
<div class="row">

    <div class="panel panel-default">
        <div class="panel-heading">
            Book list
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body">
            <div class="table-responsive">

                <util:pagination thispage="${page}"></util:pagination>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Format</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="book">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.category}</td>
                            <td>${book.format}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /.table-responsive -->
        </div>
        <!-- /.panel-body -->
    </div>

</div>
<!-- /.row -->

<!-- /#page-wrapper -->

<jsp:include page="../footer.jsp"/>
