/*     */ package view.interrupter;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ 
/*     */ public class IDebugPanelAbs extends Interrupter {
/*  27 */   private final GuiSection section = new GuiSection();
/*     */   private final Type current;
/*     */   private final GPanel panel;
/*     */   
/*  31 */   private final StringInputSprite filter = (new StringInputSprite(20, (UI.FONT()).M)
/*     */     {
/*     */       protected void change() {
/*  34 */         IDebugPanelAbs.this.current.init(0);
/*     */       }
/*  36 */     }).placeHolder("Search");
/*  37 */   private final StringInputSprite.InputClickable fc = this.filter.c(DIR.W).colors(COLOR.WHITE65, COLOR.WHITE2WHITE);
/*     */   private final InterManager manager;
/*     */   
/*     */   public void show() {
/*  41 */     show(this.manager);
/*  42 */     this.fc.focus();
/*     */   }
/*     */   
/*     */   public IDebugPanelAbs(InterManager manager, TreeMap<CharSequence, CLICKABLE> hash) {
/*  46 */     desturberSet();
/*  47 */     this.manager = manager;
/*  48 */     addMisc();
/*  49 */     this.panel = (new GPanel()).setDim(1000, 700);
/*  50 */     this.panel.setBig();
/*  51 */     this.panel.setCloseAction(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  54 */             IDebugPanelAbs.this.hide();
/*     */           }
/*     */         });
/*     */     
/*  58 */     this.panel.setTitle("Debugger Panel", (UI.FONT()).H2);
/*  59 */     this.section.add((RENDEROBJ)this.panel);
/*     */ 
/*     */     
/*  62 */     this.current = new Type(hash);
/*     */     
/*  64 */     this.section.body().centerIn(C.DIM());
/*     */     
/*  66 */     Rec rec = this.panel.inner();
/*  67 */     this.fc.body().moveX1Y1(rec.x1(), (rec.y1() + 20));
/*  68 */     this.section.add((RENDEROBJ)this.fc);
/*     */     
/*  70 */     hash.clear();
/*  71 */     this.current.init(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addMisc() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  81 */     this.section.hover(mCoo);
/*  82 */     this.current.hover(mCoo);
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  88 */     if (button == MButt.LEFT) {
/*  89 */       this.section.click();
/*  90 */       this.current.click();
/*     */     }
/*  92 */     else if (button == MButt.RIGHT) {
/*  93 */       hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/*  99 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 104 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 105 */     this.current.render((SPRITE_RENDERER)r, ds);
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 111 */     if ((KEYS.MAIN()).ESCAPE.consumeClick()) {
/* 112 */       hide();
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   private class Type
/*     */     extends GuiSection {
/*     */     private final TreeMap<String, CLICKABLE> items;
/* 120 */     private int itemCount = 0;
/* 121 */     private int itemLast = 0;
/*     */     private CLICKABLE next;
/*     */     private CLICKABLE prev;
/* 124 */     private final int maxrows = (int)(25.0D * C.HEIGHT() / 1000.0D);
/*     */ 
/*     */     
/*     */     Type(TreeMap<CharSequence, CLICKABLE> items) {
/* 128 */       this.items = (TreeMap<String, CLICKABLE>)items.clone();
/* 129 */       this.next = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA() {
/* 132 */             IDebugPanelAbs.Type.this.prev.activeSet(true);
/* 133 */             IDebugPanelAbs.Type.this.init(IDebugPanelAbs.Type.this.itemLast);
/*     */           }
/*     */         };
/* 136 */       this.prev = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA() {
/* 139 */             IDebugPanelAbs.Type.this.next.activeSet(true);
/* 140 */             IDebugPanelAbs.Type.this.init(IDebugPanelAbs.Type.this.itemLast - IDebugPanelAbs.Type.this.itemCount - IDebugPanelAbs.Type.this.maxrows * 2);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     void init(int first) {
/* 146 */       this.itemCount = 0;
/* 147 */       this.itemLast = first;
/* 148 */       clear();
/* 149 */       Rec rec = IDebugPanelAbs.this.panel.inner();
/* 150 */       body().moveX1Y1(rec.x1(), (IDebugPanelAbs.this.fc.body().y2() + 10));
/* 151 */       int x1 = body().x1();
/* 152 */       int y1 = body().y1();
/* 153 */       this.prev.activeSet((first != 0));
/* 154 */       this.next.activeSet(false);
/* 155 */       int i = 0;
/* 156 */       int rows = 0;
/* 157 */       int cols = 0;
/*     */       
/* 159 */       for (Map.Entry<String, CLICKABLE> c : this.items.entrySet()) {
/*     */         
/* 161 */         i++;
/* 162 */         if ((IDebugPanelAbs.this.filter.text().length() != 0 && !Str.containsText(c.getKey(), (CharSequence)IDebugPanelAbs.this.filter.text())) || i < first)
/*     */           continue; 
/* 164 */         rows++;
/* 165 */         if (rows > this.maxrows) {
/* 166 */           cols++;
/* 167 */           if (cols == 2) {
/* 168 */             this.next.activeSet(true);
/*     */             
/*     */             break;
/*     */           } 
/* 172 */           rows = 1;
/* 173 */           x1 += rec.width() / 2;
/* 174 */           y1 = body().y1();
/*     */         } 
/* 176 */         this.itemLast++;
/* 177 */         this.itemCount++;
/* 178 */         CLICKABLE cl = c.getValue();
/* 179 */         cl.body().moveX1Y1(x1, y1);
/* 180 */         add((RENDEROBJ)cl);
/* 181 */         y1 += cl.body().height();
/*     */       } 
/*     */       
/* 184 */       this.prev.body().moveX1(rec.x1());
/* 185 */       this.prev.body().moveY2(rec.y2());
/* 186 */       this.next.body().moveX2(rec.x2());
/* 187 */       this.next.body().moveY2(rec.y2());
/* 188 */       add((RENDEROBJ)this.prev);
/* 189 */       add((RENDEROBJ)this.next);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IDebugPanelAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */