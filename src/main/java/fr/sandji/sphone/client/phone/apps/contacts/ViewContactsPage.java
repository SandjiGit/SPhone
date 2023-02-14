package fr.sandji.sphone.client.phone.apps.contacts;

import fr.aym.acsguis.api.ACsGuiApi;
import fr.aym.acsguis.component.layout.GridLayout;
import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiScrollPane;
import fr.aym.acsguis.component.textarea.GuiLabel;
import fr.aym.acsguis.component.textarea.GuiTextArea;
import fr.sandji.sphone.client.phone.HomePage;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static fr.sandji.sphone.client.phone.apps.contacts.ContactManager.contacts;

public class ViewContactsPage extends GuiFrame {

    public ViewContactsPage(String name, String last_name, int phone_number, String notes) {
        super(new GuiScaler.AdjustFullScreen());
        style.setBackgroundColor(Color.TRANSLUCENT);
        setCssClass("home");

        GuiLabel phone_background = new GuiLabel("");
        phone_background.setCssId("phone_background_gray");
        add(phone_background);

        GuiLabel phone_case = new GuiLabel("");
        phone_case.setCssId("phone_case");
        add(phone_case);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        GuiLabel phone_clock = new GuiLabel(dateFormat.format(date));
        phone_clock.setCssId("phone_clock");
        add(phone_clock);

        GuiLabel phone_top_icons = new GuiLabel("");
        phone_top_icons.setCssId("phone_top_icons");
        add(phone_top_icons);

        GuiLabel phone_task_bar = new GuiLabel("");
        phone_task_bar.setCssId("phone_task_bar");
        phone_task_bar.addClickListener((x,y,bu) -> {
            ACsGuiApi.asyncLoadThenShowGui("ContactsPage", ContactsPage::new);
        });
        add(phone_task_bar);

        GuiLabel contact_avatar = new GuiLabel("");
        contact_avatar.setCssId("contact_avatar");
        add(contact_avatar);

        GuiLabel call_back = new GuiLabel("");
        call_back.setCssId("call_back");
        add(call_back);

        GuiLabel message_back = new GuiLabel("");
        message_back.setCssId("message_back");
        add(message_back);

        GuiLabel edit_back = new GuiLabel("");
        edit_back.setCssId("edit_back");
        edit_back.addClickListener((x,y,bu) -> {
            mc.displayGuiScreen(new EditContactsPage(name, last_name, phone_number, notes).getGuiScreen());
        });
        add(edit_back);

        GuiLabel contact_name = new GuiLabel(name + " " + last_name);
        contact_name.setCssId("name");
        add(contact_name);

        GuiLabel phone = new GuiLabel(" Numéro : " + String.valueOf(phone_number));
        phone.setCssId("phone");
        add(phone);

        GuiTextArea contacts_notes = new GuiTextArea();
        contacts_notes.setCssId("note");
        contacts_notes.setText(" " + notes);
        contacts_notes.setEditable(false);
        add(contacts_notes);

    }

    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("sphone:css/contacts.css"));
    }

    @Override
    public boolean needsCssReload() {
        return true;
    }

    @Override
    public boolean doesPauseGame() {
        return false;
    }

}
