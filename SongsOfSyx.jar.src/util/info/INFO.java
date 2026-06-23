/*    */ package util.info;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import view.ui.wiki.WIKI;
/*    */ 
/*    */ public class INFO
/*    */ {
/*    */   public final CharSequence name;
/*    */   public final CharSequence names;
/*    */   public final CharSequence desc;
/*    */   public final ACTION wiki;
/*    */   
/*    */   public INFO(Json json, ACTION wiki) {
/* 16 */     if (!json.has("NAME"))
/* 17 */       json = json.json("INFO"); 
/* 18 */     this.name = json.text("NAME");
/* 19 */     if (json.has("NAMES")) {
/* 20 */       this.names = json.text("NAMES");
/*    */     } else {
/* 22 */       this.names = this.name;
/* 23 */     }  this.desc = json.text("DESC");
/* 24 */     if (wiki == null)
/* 25 */       wiki = WIKI.add(json); 
/* 26 */     this.wiki = wiki;
/*    */   }
/*    */   
/*    */   public INFO(Json json) {
/* 30 */     this(json, (ACTION)null);
/*    */   }
/*    */   
/*    */   public INFO(CharSequence name, CharSequence desc) {
/* 34 */     this(String.valueOf(name), String.valueOf(name) + "s", desc, null);
/*    */   }
/*    */   
/*    */   public INFO(CharSequence name, CharSequence names, CharSequence desc, ACTION wiki) {
/* 38 */     this.name = name;
/* 39 */     this.names = names;
/* 40 */     this.desc = desc;
/* 41 */     this.wiki = wiki;
/*    */   }
/*    */   
/*    */   public void hover(GUI_BOX box) {
/* 45 */     box.title(this.name);
/* 46 */     box.text(this.desc);
/* 47 */     box.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\info\INFO.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */