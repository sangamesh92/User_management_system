package com.hg_christmas.template;

import org.springframework.stereotype.Component;

@Component
public class SecretSantaEmailTemplate {

    public String buildAssignmentMail(String giverName, String receiverName) {

        return """
        <html>
        <body style="margin:0; padding:0; background-color:#f4f6f8;">

        <table width="100%%" cellpadding="0" cellspacing="0" bgcolor="#f4f6f8">
            <tr>
                <td align="center" style="padding:20px 10px;">

                    <!-- CONTAINER -->
                    <table width="600" cellpadding="0" cellspacing="0"
                           style="max-width:600px; width:100%%;
                           background:#ffffff;
                           font-family:Arial, sans-serif;
                           color:#333;
                           border-radius:8px;">

                        <!-- HEADER -->
                        <tr>
                            <td align="center" style="padding:20px;">
                                <h2 style="margin:0; color:#2c3e50; line-height:1.4;">
                                    🎄 Secret Santa Celebration 🎁✨
                                </h2>
                            </td>
                        </tr>

                        <!-- GREETING -->
                        <tr>
                            <td style="padding:12px 20px; font-size:15px; line-height:1.6;">
                                Hello <strong>%s</strong>,
                            </td>
                        </tr>

                        <tr>
                            <td style="padding:0 20px 12px; font-size:15px; line-height:1.6;">
                                You are officially part of our
                                <strong>Secret Santa celebration!</strong> 🎉
                            </td>
                        </tr>

                        <!-- ASSIGNMENT -->
                        <tr>
                            <td align="center" style="padding:15px 20px;">
                                <table width="100%%" cellpadding="0" cellspacing="0"
                                       style="background:#f1f8e9; border-radius:6px;">
                                    <tr>
                                        <td align="center" style="padding:15px; line-height:1.6;">
                                            🎁 <strong>Your Secret Santa Assignment</strong><br><br>
                                            You are the Secret Santa for<br>
                                            <span style="font-size:20px; color:#2e7d32; font-weight:bold;">
                                                %s
                                            </span>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                        <!-- SECRET NOTE -->
                        <tr>
                            <td style="padding:12px 20px; font-size:14px;">
                                🔒 <strong>Please keep this a secret</strong> 🤫
                            </td>
                        </tr>

                        <!-- GIFT GUIDELINES -->
                        <tr>
                            <td style="padding:12px 20px; font-size:14px; line-height:1.6;">
                                <strong>💰 Gift Guidelines:</strong>
                                <ul style="padding-left:18px; margin:8px 0;">
                                    <li>Minimum price: ₹250</li>
                                    <li>Be thoughtful, creative, and fun</li>
                                    <li>Handmade or surprise gifts are welcome</li>
                                </ul>
                            </td>
                        </tr>

                        <!-- DAILY GIFTS -->
                        <tr>
                            <td style="padding:12px 20px;">
                                <table width="100%%" cellpadding="0" cellspacing="0"
                                       style="background:#e3f2fd; border-radius:6px;">
                                    <tr>
                                        <td style="padding:15px; font-size:14px; line-height:1.6;">
                                            🎁 <strong>Daily Surprise Fun:</strong><br>
                                            You may give small daily gifts, notes, or surprises
                                            to make their days special 😊
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                        <!-- EVENT DETAILS -->
                        <tr>
                            <td style="padding:12px 20px;">
                                <table width="100%%" cellpadding="0" cellspacing="0"
                                       style="background:#fff3e0; border-radius:6px;">
                                    <tr>
                                        <td style="padding:15px; font-size:14px; line-height:1.6;">
                                            🎄 <strong>24th December – Final Celebration</strong><br><br>

                                            🎁 Final Secret Santa gift exchange<br>
                                            🎉 Reveal your Secret Santa through a fun game<br><br>

                                            👗 <strong>Dress Code:</strong> White or Red<br><br>

                                            Let’s celebrate together and make this day memorable 🎄
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                        <!-- REQUEST -->
                        <tr>
                            <td style="padding:12px 20px; font-size:14px; line-height:1.6;">
                                🤝 <strong>Let’s Make It Memorable:</strong><br>
                                Please avoid WFH or planned leave on the event day.
                            </td>
                        </tr>

                        <!-- REMINDER -->
                        <tr>
                            <td style="padding:12px 20px; font-size:14px;">
                                🎁 Remember: It’s not about the price, but the joy and effort.
                            </td>
                        </tr>

                        <!-- FOOTER -->
                        <tr>
                            <td align="center" style="padding:20px; font-size:14px;">
                                <strong>Have fun spreading smiles and surprises!</strong> 😊<br><br>
                                Warm regards,<br>
                                <strong>PGC Digital – Secret Santa Team</strong> ✨
                            </td>
                        </tr>

                    </table>
                    <!-- END CONTAINER -->

                </td>
            </tr>
        </table>

        </body>
        </html>
        """.formatted(giverName, receiverName);
    }
}
