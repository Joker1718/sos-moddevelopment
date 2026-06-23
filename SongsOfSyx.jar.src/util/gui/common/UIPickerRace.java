/*    */ package util.gui.common;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ public class UIPickerRace {
/* 19 */   public final GuiSection section = new GuiSection();
/*    */   private final LIST<Race> all;
/* 21 */   private int current = 0;
/*    */   
/*    */   public UIPickerRace() {
/* 24 */     this(RACES.all());
/*    */   }
/*    */   
/*    */   public UIPickerRace(LIST<Race> races) {
/* 28 */     this.all = races;
/*    */     
/* 30 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_left)
/*    */       {
/*    */         protected void clickA() {
/* 33 */           UIPickerRace.this.set(UIPickerRace.this.current - 1);
/* 34 */           super.clickA();
/*    */         }
/*    */       };
/* 37 */     b.body.setHeight(46.0D);
/* 38 */     b.pad(1, 0);
/* 39 */     this.section.add((RENDEROBJ)b);
/*    */     
/* 41 */     this.section.addRightC(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(80, 46)
/*    */         {
/*    */ 
/*    */           
/*    */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*    */           {
/* 47 */             GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 48 */             GCOLOR.UI().bg().render(r, (RECTANGLE)this.body, -1);
/* 49 */             COLOR.WHITE35.bind();
/*    */             
/* 51 */             (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current - 1)).appearance()).icon.renderC(r, this.body.cX() - 18, this.body.cY());
/* 52 */             (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current + 1)).appearance()).icon.renderC(r, this.body.cX() + 18, this.body.cY());
/* 53 */             COLOR.unbind();
/* 54 */             (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current)).appearance()).iconBig.renderC(r, this.body.cX(), this.body.cY());
/*    */           }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GUI_BOX text) {
/* 62 */             UIPickerRace.this.hover((GBox)text, (Race)UIPickerRace.this.all.getC(UIPickerRace.this.current));
/*    */           }
/*    */         });
/*    */ 
/*    */ 
/*    */     
/* 68 */     b = new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_right)
/*    */       {
/*    */         protected void clickA() {
/* 71 */           UIPickerRace.this.set(UIPickerRace.this.current + 1);
/* 72 */           super.clickA();
/*    */         }
/*    */       };
/* 75 */     b.body.setHeight(46.0D);
/* 76 */     b.pad(1, 0);
/* 77 */     this.section.addRightC(0, (RENDEROBJ)b);
/*    */   }
/*    */   
/*    */   public void set(Race race) {
/* 81 */     for (int i = 0; i < this.all.size(); i++) {
/* 82 */       if (this.all.get(i) == race)
/* 83 */         this.current = i; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void set(int ri) {
/* 88 */     this.current = ri;
/* 89 */     this.current = MATH.mod(this.current, this.all.size());
/*    */   }
/*    */   
/*    */   public void hover(GBox b, Race race) {
/* 93 */     b.title(race.info.names);
/* 94 */     b.text(race.info.desc);
/* 95 */     b.NL();
/*    */   }
/*    */   
/*    */   public Race race() {
/* 99 */     return (Race)this.all.getC(this.current);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */