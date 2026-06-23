/*    */ package game.nobility;
/*    */ 
/*    */ import game.boosting.BoostSpecs;
/*    */ import game.boosting.Boostable;
/*    */ import init.sprite.UI.Icon;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ public abstract class NobleOffice {
/*    */   public final CharSequence name;
/*    */   public final CharSequence desc;
/*    */   public final BoostSpecs boosts;
/*    */   public final double add;
/*    */   public final Boostable target;
/*    */   public final Icon icon;
/*    */   public final int index;
/*    */   public boolean special;
/*    */   
/*    */   NobleOffice(ArrayListGrower<NobleOffice> all, double add, Boostable target, CharSequence name, CharSequence desc, Icon icon) {
/* 26 */     this.add = add;
/* 27 */     this.target = target;
/* 28 */     this.name = name;
/* 29 */     this.desc = desc;
/* 30 */     this.boosts = new BoostSpecs((HCLASSES.NOBLE()).name, (SPRITE)(UI.icons()).s.noble, false);
/* 31 */     this.boosts.push(target, add, false);
/* 32 */     this.icon = icon;
/* 33 */     this.index = all.add(this);
/*    */   }
/*    */   
/*    */   public abstract double value(int paramInt);
/*    */   
/*    */   public abstract int popBoosted(int paramInt);
/*    */   
/*    */   public abstract void hoverValue(GBox paramGBox, int paramInt);
/*    */   
/*    */   public int allocated(Noble n) {
/* 43 */     if (n.office() == this)
/* 44 */       return 1 + 4 * n.rank(); 
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */   public RoomBlueprintIns<?> room() {
/* 49 */     return null;
/*    */   }
/*    */   
/*    */   public boolean leavesMap() {
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public void hover(GUI_BOX box) {
/* 57 */     GBox b = (GBox)box;
/* 58 */     b.title(this.name);
/* 59 */     b.text(this.desc);
/* 60 */     b.NL(4);
/* 61 */     b.add((SPRITE)this.target.icon);
/* 62 */     b.textL(this.target.name);
/* 63 */     b.tab(6);
/* 64 */     double d = value(1);
/* 65 */     d *= this.add;
/* 66 */     b.add((SPRITE)GFORMAT.f0(b.text(), d, 4.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NobleOffice.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */