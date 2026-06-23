/*     */ package view.sett.ui.subject;
/*     */ import game.GAME;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.ai.types.parent.AIModule_Parent;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import settlement.stats.equip.StatsEquip;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UISubjectEquip extends GuiSection {
/*  32 */   private static CharSequence ¤¤resource = "¤Carried resource";
/*  33 */   private static CharSequence ¤¤infant = "¤Currently caring for offspring. Can not work. Child will grow up in {0} days.";
/*     */   
/*     */   static {
/*  36 */     D.ts(UISubjectEquip.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UISubjectEquip(final AInfo a, HTYPE t) {
/*  44 */     StatsEquip pr = STATS.EQUIP();
/*     */     
/*  46 */     int ii = 0;
/*  47 */     int rrr = 4;
/*  48 */     for (Equip pp : pr.allE()) {
/*  49 */       final STAT p = pp.stat();
/*  50 */       CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(40, 44) {
/*  51 */           private final GText t = new GText((UI.FONT()).S, 8);
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  56 */             if (isHovered) {
/*  57 */               COLOR.BLUEDARK.render(r, (RECTANGLE)body());
/*     */             }
/*     */             
/*  60 */             pp.resource().icon().renderC(r, body().cX(), body().y1() + 16);
/*  61 */             this.t.clear();
/*  62 */             int am = p.indu().get(a.a.indu());
/*  63 */             int max = pp.max(a.a.indu());
/*  64 */             GFORMAT.iofk(this.t, am, max);
/*  65 */             this.t.lablify();
/*  66 */             this.t.adjustWidth();
/*  67 */             this.t.renderC(r, body().cX(), body().y1() + 32);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  73 */             pp.hover(text, a.a.indu());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  78 */             if ((S.get()).developer) {
/*  79 */               DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)p.indu(), a.a);
/*     */             } else {
/*  81 */               (VIEW.s()).ui.standing.openAccess(a.a.race());
/*     */             } 
/*     */           }
/*     */         };
/*  85 */       addGrid((RENDEROBJ)clickableAbs, ii++, 4, 4, 4);
/*     */     } 
/*     */ 
/*     */     
/*  89 */     GuiSection ss = new GuiSection();
/*  90 */     ss.addRightC(8, (RENDEROBJ)new HOVERABLE.HoverableAbs(72, 24) {
/*  91 */           private final GText t = new GText((UI.FONT()).M, 4);
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  94 */             if (a.a.indu().hType() == HTYPES.PARENT() || a.a.indu().hType() == HTYPES.PARENT_SLAVE()) {
/*  95 */               this.t.clear().add(((a.a.race()).physics.babyDays - AIModule_Parent.daysOld(a.a)));
/*  96 */               this.t.renderCY(r, body().x1(), body().cY());
/*  97 */               (UI.icons()).m.baby.render(r, body().x1() + 24, body().y1());
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 103 */             if (a.a.indu().hType() == HTYPES.PARENT() || a.a.indu().hType() == HTYPES.PARENT_SLAVE()) {
/* 104 */               GBox b = (GBox)text;
/* 105 */               GText t = b.text();
/* 106 */               t.add(UISubjectEquip.¤¤infant);
/* 107 */               t.insert(0, (a.a.race()).physics.babyDays - AIModule_Parent.daysOld(a.a));
/* 108 */               b.add((SPRITE)t);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 113 */     GETTER<HCLASS_RACE> g = new GETTER<HCLASS_RACE>()
/*     */       {
/*     */         public HCLASS_RACE get()
/*     */         {
/* 117 */           return HCLASS_RACE.clP(a.a.indu());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 122 */     ss.addRightC(8, (RENDEROBJ)TmpBoostingButt.make(g, (GAME.BOOST()).popcl));
/*     */     
/* 124 */     ss.addRightC(8, (RENDEROBJ)new HOVERABLE.HoverableAbs(72, 24) {
/* 125 */           private final GText t = new GText((UI.FONT()).M, 4);
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 128 */             if (a.a.ai().resourceCarried() != null) {
/* 129 */               this.t.clear().add(a.a.ai().resourceA());
/* 130 */               this.t.renderCY(r, body().x1(), body().cY());
/* 131 */               a.a.ai().resourceCarried().icon().render(r, body().x1() + 24, body().y1());
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 137 */             text.text(UISubjectEquip.¤¤resource);
/* 138 */             text.NL();
/* 139 */             if (a.a.ai().resourceCarried() != null) {
/* 140 */               text.text((a.a.ai().resourceCarried()).name);
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 146 */     addRelBody(8, DIR.N, (RENDEROBJ)ss);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */