/*     */ package view.ui.log;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.D;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.log.LogEntry;
/*     */ 
/*     */ public final class UILog extends Interrupter {
/*  33 */   public static CharSequence ¤¤name = "World log";
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  38 */     D.ts(UILog.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  43 */   private final GuiSection section = new GuiSection();
/*     */   public UILog(VIEW view) {
/*  45 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  49 */           return WORLD.LOG().all().size();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  54 */     builder.column(null, 450, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier) {
/*  57 */             return (RENDEROBJ)new UILog.Entry(ier);
/*     */           }
/*     */         });
/*     */     
/*  61 */     this.section.add((RENDEROBJ)builder.createHeight(700, false));
/*     */     
/*  63 */     GPanel p = (new GPanel()).setBig();
/*  64 */     p.set((RECTANGLE)this.section.body());
/*     */     
/*  66 */     p.setCloseAction(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  69 */             UILog.this.hide();
/*     */           }
/*     */         });
/*  72 */     p.body().centerY(C.DIM());
/*  73 */     p.body().moveX2((C.WIDTH() - 20));
/*  74 */     this.section.body().centerIn((BODY_HOLDER)p);
/*  75 */     this.section.add((RENDEROBJ)p);
/*  76 */     this.section.moveLastToBack();
/*  77 */     p.setTitle(¤¤name, (UI.FONT()).H2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int ww = 450;
/*     */   
/*     */   public void activate() {
/*  84 */     show((VIEW.inters()).manager);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  89 */     this.section.hover(mCoo);
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  95 */     if (button == MButt.LEFT)
/*  96 */       this.section.click(); 
/*  97 */     if (button == MButt.RIGHT) {
/*  98 */       hide();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 103 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 108 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 115 */     return true;
/*     */   }
/*     */   
/*     */   private static class Entry
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final GETTER<Integer> ier;
/* 121 */     private static final Str tmp = new Str(128);
/*     */     
/*     */     Entry(GETTER<Integer> ier) {
/* 124 */       super(450, (UI.FONT()).M.height() * 2 + 30 + 16);
/* 125 */       this.ier = ier;
/*     */     }
/*     */     
/*     */     private LogEntry e() {
/* 129 */       if (((Integer)this.ier.get()).intValue() >= WORLD.LOG().all().size())
/* 130 */         return null; 
/* 131 */       return (LogEntry)WORLD.LOG().all().get(WORLD.LOG().all().size() - 1 - ((Integer)this.ier.get()).intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 136 */       LogEntry e = e();
/* 137 */       if (e == null) {
/*     */         return;
/*     */       }
/* 140 */       if (isHovered) {
/* 141 */         COLOR.WHITE15.render(r, (RECTANGLE)this.body);
/*     */       }
/*     */       
/* 144 */       int x1 = this.body.x1() + 16;
/* 145 */       int cy = this.body.y1() + 20;
/*     */       
/* 147 */       e.icon().renderCY(r, x1, cy);
/*     */       
/* 149 */       if (e.bannerA() != null) {
/* 150 */         (e.bannerA()).MEDIUM.renderCY(r, x1 + 24, cy);
/*     */       }
/* 152 */       if (e.bannerB() != null) {
/* 153 */         (e.bannerB()).MEDIUM.renderCY(r, x1 + 50, cy);
/*     */       }
/*     */       
/* 156 */       tmp.clear();
/* 157 */       DicTime.setDateShort(tmp, e.daySinceStart() * TIME.secondsPerDay());
/*     */       
/* 159 */       (GCOLOR.T()).H1.bind();
/* 160 */       (UI.FONT()).H2.render(r, (CharSequence)tmp, x1 + 76, cy - (UI.FONT()).H2.height() / 2);
/* 161 */       COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 168 */       x1 = this.body.x1();
/* 169 */       int y1 = this.body.y1() + 32;
/* 170 */       (UI.FONT()).M.renderIn(r, x1, y1, DIR.NW, (CharSequence)e.message, this.body.width(), this.body.y2() - y1 - 8, 1.0D);
/*     */ 
/*     */       
/* 173 */       GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 179 */       LogEntry e = e();
/* 180 */       if (e == null)
/*     */         return; 
/* 182 */       VIEW.world().activate();
/* 183 */       (VIEW.world()).window.centererTile.set(e.tx(), e.ty());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 188 */       LogEntry e = e();
/* 189 */       if (e == null)
/*     */         return; 
/* 191 */       text.text((CharSequence)e.message);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\log\UILog.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */