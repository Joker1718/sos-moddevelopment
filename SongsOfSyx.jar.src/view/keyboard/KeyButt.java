/*    */ package view.keyboard;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class KeyButt
/*    */ {
/* 12 */   private static CharSequence ¤¤assign = "¤To assign a new hotkey to this function, press: ";
/*    */ 
/*    */   
/*    */   static {
/* 16 */     D.ts(KeyButt.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static CLICKABLE wrap(final CLICKABLE base, final Key key) {
/* 23 */     return (CLICKABLE)new CLICKABLE.ClickWrap((RENDEROBJ)base)
/*    */       {
/*    */         public void hoverInfoGet(GUI_BOX text)
/*    */         {
/* 27 */           text.title(key.name);
/* 28 */           text.text(key.desc);
/* 29 */           text.NL(4);
/* 30 */           super.hoverInfoGet(text);
/* 31 */           text.NL(8);
/* 32 */           key.setMapping(text);
/* 33 */           text.NL(2);
/* 34 */           if (key.rebindable) {
/* 35 */             text.text(KeyButt.¤¤assign);
/* 36 */             text.text((KEYS.MAIN()).ASSIGN_HOTKEY.repr());
/*    */           } 
/* 38 */           text.NL(8);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean hover(COORDINATE mCoo) {
/* 44 */           if (super.hover(mCoo)) {
/* 45 */             if (key.rebindable)
/* 46 */               (KEYS.get()).toChange = key; 
/* 47 */             return true;
/*    */           } 
/* 49 */           return false;
/*    */         }
/*    */ 
/*    */         
/*    */         protected RENDEROBJ pget() {
/* 54 */           return (RENDEROBJ)base;
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public static CLICKABLE wrap(ACTION a, CLICKABLE base, KeyPage page, String code, CharSequence name, CharSequence desc) {
/* 61 */     return wrap(a, base, page, code, name, desc, -1, -1);
/*    */   }
/*    */   
/*    */   public static CLICKABLE wrap(ACTION a, CLICKABLE base, KeyPage page, String code, CharSequence name, CharSequence desc, int mod, int key) {
/* 65 */     for (Key key1 : page.all) {
/* 66 */       if (key1.key.equals(code)) {
/* 67 */         key1.action = a;
/* 68 */         return wrap(base, key1);
/*    */       } 
/*    */     } 
/*    */     
/* 72 */     Key k = new Key(code, name, desc, page, mod, key, true);
/* 73 */     k.action = a;
/* 74 */     return wrap(base, k);
/*    */   }
/*    */   
/*    */   public static void hover(Key key, GUI_BOX text) {
/* 78 */     text.title(key.name);
/* 79 */     text.text(key.desc);
/* 80 */     text.NL(8);
/* 81 */     key.setMapping(text);
/* 82 */     text.NL(2);
/* 83 */     if (key.rebindable) {
/* 84 */       text.text(¤¤assign);
/* 85 */       text.text((KEYS.MAIN()).ASSIGN_HOTKEY.repr());
/*    */     } 
/* 87 */     text.NL(8);
/*    */   }
/*    */   
/*    */   public static Key key(ACTION a, KeyPage page, String code, CharSequence name, CharSequence desc, int mod, int key) {
/* 91 */     Key k = new Key(code, name, desc, page, mod, key, true);
/* 92 */     return k;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */