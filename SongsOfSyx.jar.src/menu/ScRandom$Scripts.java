/*     */ package menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import script.ScriptEngine;
/*     */ import script.ScriptLoad;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.gui.table.GScrollRows;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Scripts
/*     */   extends GuiSection
/*     */ {
/*     */   Scripts(int height) {
/* 259 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/* 260 */     for (ScriptLoad l : ScriptEngine.getAll()) {
/* 261 */       if (!l.script.isSelectable())
/*     */         continue; 
/* 263 */       final CharSequence name = l.script.name();
/* 264 */       final CharSequence desc = l.script.desc();
/*     */       
/* 266 */       GUI.CheckBox checkBox = new GUI.CheckBox(name)
/*     */         {
/*     */           public boolean hover(COORDINATE mCoo) {
/* 269 */             if (super.hover(mCoo)) {
/* 270 */               (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).hname = name;
/* 271 */               (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).hdesc = desc;
/* 272 */               return true;
/*     */             } 
/* 274 */             return false;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 280 */             if ((ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.containsKey(l.className)) {
/* 281 */               (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.remove(l.className);
/* 282 */               selectedSet(false);
/*     */             } else {
/* 284 */               (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.put(l.className, l);
/* 285 */               selectedSet(true);
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 291 */       rows.add(checkBox);
/*     */     } 
/*     */     
/* 294 */     if (rows.size() > 0) {
/* 295 */       add((RENDEROBJ)(new GScrollRows((Iterable)rows, height)).view());
/* 296 */       addRelBody(4, DIR.N, (RENDEROBJ)new HOVERABLE.Sprite((UI.FONT()).H2.getText(ScRandom.¤¤Scripts), GUI.COLORS.label));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScRandom$Scripts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */