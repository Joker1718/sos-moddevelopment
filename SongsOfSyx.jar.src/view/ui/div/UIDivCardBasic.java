/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class UIDivCardBasic implements DIMENSION {
/*     */   private final int WIDTH;
/*     */   private final int HEIGHT;
/*     */   private final UIDiv m;
/*  33 */   private final Rec body = new Rec();
/*     */   
/*  35 */   private GuiSection sec = new GuiSection();
/*     */   private DIV_SPEC current;
/*  37 */   private final UIDivStats stat = new UIDivStats();
/*     */   
/*     */   UIDivCardBasic(UIDiv m) {
/*  40 */     this.m = m;
/*  41 */     m.getClass(); this.WIDTH = 58;
/*  42 */     m.getClass(); this.HEIGHT = 78;
/*     */ 
/*     */     
/*  45 */     GuiSection s = new GuiSection();
/*     */     
/*  47 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*  48 */       SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  52 */             if (UIDivCardBasic.this.current.equip(e) == 0.0D) {
/*  53 */               OPACITY.O50.bind();
/*     */             }
/*  55 */             e.resource.icon().render(r, X1, X2, Y1, Y2);
/*  56 */             OPACITY.unbind();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  61 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  65 */             if (UIDivCardBasic.this.current.equip(e) == 0.0D) {
/*  66 */               text.color(COLOR.WHITE50).add('-');
/*     */             } else {
/*  68 */               GFORMAT.f(text, 10.0D * UIDivCardBasic.this.current.equip(e) * e.equipMax / 10.0D, 1);
/*     */             } 
/*     */           }
/*  71 */         }).hh((SPRITE)imp);
/*  72 */       s.addGrid((RENDEROBJ)hOVERABLE, e.indexMilitary(), 4, 48, 0);
/*     */     } 
/*     */ 
/*     */     
/*  76 */     (GCOLOR.T()).H1.bind();
/*  77 */     s.add((SPRITE)(UI.icons()).s.death, 0, s.body().y2() + 2);
/*     */     
/*  79 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  83 */             GFORMAT.percGood(text, 100.0D * UIDivCardBasic.this.current.experience() / 100.0D);
/*     */           }
/*  85 */         }).hh(Dic.¤¤Experience, 220));
/*     */     
/*  87 */     for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/*  88 */       s.add(tt.room.icon.small, 0, s.body().y2() + 2);
/*  89 */       s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  93 */               GFORMAT.percGood(text, (int)(100.0D * UIDivCardBasic.this.current.training(tt)) / 100.0D);
/*     */             }
/*  95 */           }).hh((tt.stat.info()).name, 220));
/*     */     } 
/*     */     
/*  98 */     this.sec.add((RENDEROBJ)s);
/*     */     
/* 100 */     this.sec.addRelBody(8, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(this.WIDTH * 2, this.HEIGHT * 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 104 */             UIDivCardBasic.this.render(r, this.body.x1(), this.body.y1(), 2, UIDivCardBasic.this.current, true, false, false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 113 */     return this.WIDTH;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 118 */     return this.HEIGHT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int scale, DIV_SPEC d, boolean isActive, boolean isSelected, boolean isHovered) {
/* 123 */     if (d == null) {
/*     */       return;
/*     */     }
/* 126 */     this.body.set(x1, (x1 + this.WIDTH * scale), y1, (y1 + this.HEIGHT * scale));
/* 127 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 129 */     this.m.renderBasics(r, x1, y1, scale, d);
/*     */     
/* 131 */     int cx = this.body.cX();
/*     */     
/* 133 */     COLOR.BLACK.bind();
/* 134 */     (UI.FONT()).S.renderC(r, cx + 1, this.body.y2() - 9 * scale, (CharSequence)Str.TMP.clear().add(d.men()), scale);
/* 135 */     COLOR.unbind();
/* 136 */     (UI.FONT()).S.renderC(r, cx, this.body.y2() - 10 * scale, (CharSequence)Str.TMP.clear().add(d.men()), scale);
/*     */     
/* 138 */     if (d.men() == 0 || !isActive) {
/* 139 */       OPACITY.O50.bind();
/* 140 */       COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 141 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 144 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)this.body, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(DIV_SPEC d, GUI_BOX box) {
/* 151 */     if (d == null)
/*     */       return; 
/* 153 */     GBox b = (GBox)box;
/*     */     
/* 155 */     b.title(d.name());
/*     */     
/* 157 */     this.current = d;
/* 158 */     b.add((RENDEROBJ)this.sec);
/*     */     
/* 160 */     b.sep();
/*     */     
/* 162 */     b.add((RENDEROBJ)this.stat.get(d));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardBasic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */