/*    */ package view.ui.util;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import init.value.GValueCat;
/*    */ import init.value.Value;
/*    */ import java.util.ArrayList;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GInput;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.table.GScrollRows;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class UIValues<T>
/*    */   extends GuiSection {
/*    */   public UIValues(GValueCat<T> vv, final GETTER<T> g) {
/* 27 */     final GInput filter = new GInput(new StringInputSprite(24, (UI.FONT()).S));
/* 28 */     add((RENDEROBJ)filter);
/* 29 */     final LIST<Value<T>> all = vv.map().allSorted();
/* 30 */     ArrayList<RENDEROBJ> rows = new ArrayList<>(vv.all().size());
/* 31 */     for (Value<T> v : all) {
/* 32 */       GButt.BSection bSection = new GButt.BSection()
/*    */         {
/*    */           public void hoverInfoGet(GUI_BOX text)
/*    */           {
/* 36 */             text.title(v.name);
/*    */           }
/*    */         };
/* 39 */       bSection.add(v.icon, 0, 0);
/* 40 */       GText t = new GText((UI.FONT()).S, v.key);
/* 41 */       t.setMaxChars(20);
/* 42 */       bSection.addRightC(2, (SPRITE)t);
/* 43 */       bSection.addCentredY((SPRITE)new GStat()
/*    */           {
/*    */             public void update(GText text)
/*    */             {
/* 47 */               text.add(v.d.getD(g.get()));
/*    */             }
/*    */ 
/*    */             
/*    */             public void hoverInfoGet(GBox b) {
/* 52 */               b.add(v.icon);
/* 53 */               b.text(v.name);
/*    */             }
/*    */           }, 
/* 56 */           400);
/* 57 */       bSection.body().setWidth((bSection.getLastX2() + 100));
/* 58 */       bSection.body().pad(4, 2);
/* 59 */       rows.add(bSection);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 64 */     GScrollRows s = new GScrollRows(rows, 800)
/*    */       {
/*    */         protected boolean passesFilter(int i, RENDEROBJ o)
/*    */         {
/* 68 */           if (filter.text().length() == 0)
/* 69 */             return true; 
/* 70 */           if (Str.containsText(((Value)all.get(i)).key, (CharSequence)filter.text()) || Str.containsText(((Value)all.get(i)).name, (CharSequence)filter.text()))
/* 71 */             return true; 
/* 72 */           return false;
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 77 */     addDown(4, (RENDEROBJ)s.view());
/*    */   }
/*    */   
/*    */   public static <T> CLICKABLE butt(GValueCat<T> vv, GETTER<T> g) {
/* 81 */     final UIValues<T> pop = new UIValues<>(vv, g);
/* 82 */     return (CLICKABLE)new GButt.ButtPanel((SPRITE)(UI.icons()).s.menu)
/*    */       {
/*    */         protected void clickA()
/*    */         {
/* 86 */           (VIEW.inters()).popup2.show((RENDEROBJ)pop, (CLICKABLE)this);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\UIValues.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */