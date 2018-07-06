package org.ucsf.glv.webapp.business.glverification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ucsf.glv.webapp.connection.Jdbc;
import org.ucsf.glv.webapp.util.ConvertResultSetToJson;

public class ReviewAndVerifyTransactionsBusiness {

    public String getTransactionsData(String sessionUserId, String reconGroupTitle) throws SQLException {
        String sql;
        PreparedStatement prepareStatement;

        if (reconGroupTitle.equals("Total")) {
            sql = "select ReconItemCd,ReconGroupTitle,ReconItemTitle,NotVerified,Pending,Complete, AutoComplete,PriorNotVerified,PriorPending,NotVerifiedCount,PendingCount,CompleteCount,AutoCompleteCount,PriorNotVerifiedCount,PriorPendingCount,AmtM01x,AmtM02x,AmtM03x,AmtM04x,AmtM05x,AmtM06x,AmtM07x,AmtM08x,AmtM09x,AmtM10x,AmtM11x,AmtM12x,AmtTotx from SOM_AA_TransactionSummary where SessionUserid=? order by Sort1 asc, Sort2 asc";
            prepareStatement = Jdbc.getPrepareStatement(sql);
            prepareStatement.setString(1, sessionUserId);
        } else {
            sql = "select ReconItemCd,ReconGroupTitle,ReconItemTitle,NotVerified,Pending,Complete, AutoComplete,PriorNotVerified,PriorPending,NotVerifiedCount,PendingCount,CompleteCount,AutoCompleteCount,PriorNotVerifiedCount,PriorPendingCount,AmtM01x,AmtM02x,AmtM03x,AmtM04x,AmtM05x,AmtM06x,AmtM07x,AmtM08x,AmtM09x,AmtM10x,AmtM11x,AmtM12x,AmtTotx from SOM_AA_TransactionSummary where SessionUserid=? and ReconGroupTitle=? order by Sort1 asc, Sort2 asc";
            prepareStatement = Jdbc.getPrepareStatement(sql);
            prepareStatement.setString(1, sessionUserId);
            prepareStatement.setString(2, reconGroupTitle);
        }

        ResultSet rs = prepareStatement.executeQuery();

        String json = ConvertResultSetToJson.convert(rs);

        rs.close();
        prepareStatement.close();

        return json;
    }
}
