/*     */ package view.interrupter;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
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
/*     */ class Type
/*     */   extends GuiSection
/*     */ {
/*     */   private final TreeMap<String, CLICKABLE> items;
/* 120 */   private int itemCount = 0;
/* 121 */   private int itemLast = 0;
/*     */   private CLICKABLE next;
/*     */   private CLICKABLE prev;
/* 124 */   private final int maxrows = (int)(25.0D * C.HEIGHT() / 1000.0D);
/*     */ 
/*     */   
/*     */   Type(TreeMap<CharSequence, CLICKABLE> items) {
/* 128 */     this.items = (TreeMap<String, CLICKABLE>)items.clone();
/* 129 */     this.next = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */       {
/*     */         protected void clickA() {
/* 132 */           IDebugPanelAbs.Type.this.prev.activeSet(true);
/* 133 */           IDebugPanelAbs.Type.this.init(IDebugPanelAbs.Type.this.itemLast);
/*     */         }
/*     */       };
/* 136 */     this.prev = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */       {
/*     */         protected void clickA() {
/* 139 */           IDebugPanelAbs.Type.this.next.activeSet(true);
/* 140 */           IDebugPanelAbs.Type.this.init(IDebugPanelAbs.Type.this.itemLast - IDebugPanelAbs.Type.this.itemCount - IDebugPanelAbs.Type.this.maxrows * 2);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   void init(int first) {
/* 146 */     this.itemCount = 0;
/* 147 */     this.itemLast = first;
/* 148 */     clear();
/* 149 */     Rec rec = IDebugPanelAbs.this.panel.inner();
/* 150 */     body().moveX1Y1(rec.x1(), (IDebugPanelAbs.this.fc.body().y2() + 10));
/* 151 */     int x1 = body().x1();
/* 152 */     int y1 = body().y1();
/* 153 */     this.prev.activeSet((first != 0));
/* 154 */     this.next.activeSet(false);
/* 155 */     int i = 0;
/* 156 */     int rows = 0;
/* 157 */     int cols = 0;
/*     */     
/* 159 */     for (Map.Entry<String, CLICKABLE> c : this.items.entrySet()) {
/*     */       
/* 161 */       i++;
/* 162 */       if ((IDebugPanelAbs.this.filter.text().length() != 0 && !Str.containsText(c.getKey(), (CharSequence)IDebugPanelAbs.this.filter.text())) || i < first)
/*     */         continue; 
/* 164 */       rows++;
/* 165 */       if (rows > this.maxrows) {
/* 166 */         cols++;
/* 167 */         if (cols == 2) {
/* 168 */           this.next.activeSet(true);
/*     */           
/*     */           break;
/*     */         } 
/* 172 */         rows = 1;
/* 173 */         x1 += rec.width() / 2;
/* 174 */         y1 = body().y1();
/*     */       } 
/* 176 */       this.itemLast++;
/* 177 */       this.itemCount++;
/* 178 */       CLICKABLE cl = c.getValue();
/* 179 */       cl.body().moveX1Y1(x1, y1);
/* 180 */       add((RENDEROBJ)cl);
/* 181 */       y1 += cl.body().height();
/*     */     } 
/*     */     
/* 184 */     this.prev.body().moveX1(rec.x1());
/* 185 */     this.prev.body().moveY2(rec.y2());
/* 186 */     this.next.body().moveX2(rec.x2());
/* 187 */     this.next.body().moveY2(rec.y2());
/* 188 */     add((RENDEROBJ)this.prev);
/* 189 */     add((RENDEROBJ)this.next);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IDebugPanelAbs$Type.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */