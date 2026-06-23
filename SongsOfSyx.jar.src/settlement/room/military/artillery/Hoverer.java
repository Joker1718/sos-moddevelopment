/*    */ package settlement.room.military.artillery;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ 
/*    */ class Hoverer {
/*    */   public static void hover(GBox box, ArtilleryInstance i) {
/* 12 */     ArtilleryInstance ins = i;
/*    */     
/* 14 */     if (ins.mustered()) {
/* 15 */       box.textL(Dic.¤¤Musterd);
/* 16 */       box.NL();
/* 17 */       if (i.isLoaded) {
/* 18 */         box.textL(Dic.¤¤ReadyFire);
/*    */       } else {
/* 20 */         box.textL(Dic.¤¤Reloading);
/* 21 */         box.tab(5);
/* 22 */         box.add((SPRITE)GFORMAT.perc(box.text(), i.progress()));
/*    */       } 
/* 24 */       box.NL(4);
/*    */     } 
/*    */     
/* 27 */     if (i.hasTrajectory && ins.mustered()) {
/* 28 */       box.textL(Dic.¤¤Attacking);
/*    */     }
/*    */     
/* 31 */     box.add((SPRITE)(SPRITES.icons()).s.human);
/* 32 */     box.add((SPRITE)GFORMAT.iofkInv(box.text(), ins.men, 6L));
/* 33 */     box.NL(6);
/* 34 */     box.sep();
/* 35 */     (i.blueprintI()).projectile.hover((GUI_BOX)box, (i.blueprintI()).info.name, i.blueprintI().ref() * i.getDegrade(), 133);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Hoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */