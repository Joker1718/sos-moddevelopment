/*     */ package view.ui.raider;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.raiding.Raider;
/*     */ import game.raiding.RaiderPortrait;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.ArrayList;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.D;
/*     */ 
/*     */ final class List extends GuiSection {
/*  27 */   private static CharSequence ¤¤name = "Raiders";
/*  28 */   private static CharSequence ¤¤raiding = "Raiding";
/*  29 */   private static CharSequence ¤¤atLarge = "At Large!";
/*  30 */   private static CharSequence ¤¤killed = "R.I.P.";
/*  31 */   private static CharSequence ¤¤hiding = "In Hiding";
/*  32 */   private static CharSequence ¤¤distant = "Distant";
/*     */   
/*     */   private Current c;
/*     */   
/*     */   private boolean all = true;
/*     */   
/*     */   static {
/*  39 */     D.ts(List.class);
/*     */   }
/*     */   
/*     */   public List(Current c, int height) {
/*  43 */     this.c = c;
/*  44 */     add((RENDEROBJ)new GHeader(¤¤name));
/*     */     
/*  46 */     addRightC(16, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.question)
/*     */         {
/*     */           protected void clickA() {
/*  49 */             List.this.all = !List.this.all;
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*  53 */             selectedSet(List.this.all);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  58 */     if ((S.get()).developer) {
/*  59 */       addRightC(8, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.question)
/*     */           {
/*     */             protected void clickA() {
/*  62 */               UIRaiding.debug = !UIRaiding.debug;
/*     */             }
/*     */             
/*     */             protected void renAction() {
/*  66 */               selectedSet(UIRaiding.debug);
/*     */             }
/*     */           });
/*     */       
/*  70 */       addRightC(8, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_right)
/*     */           {
/*     */             protected void clickA() {
/*  73 */               GAME.raiders().raid();
/*     */             }
/*     */           });
/*     */       
/*  77 */       addRightC(8, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.fish)
/*     */           {
/*     */             protected void clickA() {
/*  80 */               GAME.raiders().reset();
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/*  86 */     ArrayList<RENDEROBJ> rows = new ArrayList<>();
/*     */     
/*  88 */     int ri = 0; GAME.raiders().getClass(); for (; ri < 100; ri++)
/*     */     {
/*  90 */       rows.add(new RR(ri));
/*     */     }
/*     */     
/*  93 */     GScrollRows rr = new GScrollRows(rows, 70 * (height - body().height() - 16) / 70)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o)
/*     */         {
/*  97 */           if (List.this.all)
/*  98 */             return true; 
/*  99 */           Raider rr = (Raider)GAME.raiders().ALL().get(i);
/* 100 */           if (UIRaiding.statsVisible(rr))
/* 101 */             return true; 
/* 102 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 107 */     addRelBody(8, DIR.S, (RENDEROBJ)rr.view());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class RR
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final int ri;
/*     */ 
/*     */ 
/*     */     
/*     */     RR(int ri) {
/* 120 */       this.ri = ri;
/* 121 */       this.body.setDim(450.0D, 70.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 131 */       Raider rr = (Raider)GAME.raiders().ALL().get(this.ri);
/*     */       
/* 133 */       boolean active = true;
/* 134 */       isSelected = (this.ri == List.this.c.ri);
/*     */       
/* 136 */       COLOR c = COLOR.WHITE100;
/* 137 */       Str.TMP.clear();
/*     */       
/* 139 */       if ((GAME.raiders()).current.current() == rr) {
/* 140 */         c = (GCOLOR.T()).IBAD;
/* 141 */         Str.TMP.add(List.¤¤raiding);
/* 142 */       } else if (rr.defeated) {
/* 143 */         active = false;
/* 144 */         c = (GCOLOR.T()).IGREAT;
/* 145 */         Str.TMP.add(List.¤¤killed);
/* 146 */       } else if (!rr.hasInterrest()) {
/* 147 */         active = false;
/* 148 */         c = (GCOLOR.T()).WARNING;
/* 149 */         Str.TMP.add(List.¤¤distant);
/* 150 */       } else if (rr.isScared()) {
/* 151 */         active = false;
/* 152 */         c = (GCOLOR.T()).WARNING;
/* 153 */         Str.TMP.add(List.¤¤hiding);
/*     */       } else {
/* 155 */         c = (GCOLOR.T()).IBAD;
/* 156 */         Str.TMP.add(List.¤¤atLarge);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 161 */       GButt.ButtPanel.renderBG(r, active, isHovered, isSelected, (RECTANGLE)this.body);
/*     */       
/* 163 */       if (UIRaiding.portVisible(rr)) {
/* 164 */         RaiderPortrait.render(r, this.body.x1() + 8, this.body.y1() + 6, 1, rr.indu, rr.defeated);
/* 165 */         if (rr.defeated) {
/* 166 */           (UI.icons()).m.anti.render(r, this.body.x1() + 8, this.body.x1() + 8 + 40, this.body.y1() + 6, this.body.y1() + 6 + 40);
/*     */         }
/*     */       } else {
/* 169 */         (UI.icons()).m.questionmark.renderC(r, this.body.x1() + 8 + 20, this.body.y1() + 6 + 20);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       c.bind();
/* 177 */       (UI.FONT()).S.render(r, (CharSequence)Str.TMP, this.body.x1() + 64 + 16, this.body.y1() + 8 + 32);
/* 178 */       COLOR.unbind();
/*     */       
/* 180 */       (active ? OPACITY.O100 : OPACITY.O50).bind();
/* 181 */       (UI.FONT()).H2.renderCropped(r, rr.name, this.body.x1() + 64, this.body.y1() + 8, 370);
/*     */ 
/*     */       
/* 184 */       (UI.icons()).s.money.render(r, this.body.x2() - 200, this.body.y1() + 8 + 32);
/* 185 */       if (UIRaiding.statsVisible(rr)) {
/* 186 */         Str.TMP.clear().add((int)rr.worth);
/*     */       } else {
/* 188 */         Str.TMP.clear().add('?');
/* 189 */       }  (UI.FONT()).S.render(r, (CharSequence)Str.TMP, this.body.x2() - 200 + 24, this.body.y1() + 8 + 32);
/*     */       
/* 191 */       (UI.icons()).s.fist.render(r, this.body.x2() - 100, this.body.y1() + 8 + 32);
/* 192 */       if (UIRaiding.statsVisible(rr)) {
/* 193 */         Str.TMP.clear().add(rr.army.power);
/*     */       } else {
/* 195 */         Str.TMP.clear().add('?');
/*     */       } 
/* 197 */       (UI.FONT()).S.render(r, (CharSequence)Str.TMP, this.body.x2() - 100 + 24, this.body.y1() + 8 + 32);
/* 198 */       COLOR.unbind();
/* 199 */       OPACITY.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 208 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 214 */       List.this.c.ri = this.ri;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */