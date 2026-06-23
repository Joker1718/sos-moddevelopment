/*    */ package world.army.ai;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.diplomacy.DipStance;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ 
/*    */ public final class WArmyAI
/*    */ {
/* 17 */   final War war = new War();
/* 18 */   final Rebel rebel = new Rebel();
/*    */   boolean upAll = false;
/* 20 */   private ArrayList<Faction> fas = new ArrayList(FACTIONS.MAX());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SAVABLE saver;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WArmyAI() {
/* 39 */     this.saver = new SAVABLE()
/*    */       {
/*    */         public void save(FilePutter file)
/*    */         {
/* 43 */           WArmyAI.this.war.save(file);
/* 44 */           WArmyAI.this.rebel.save(file);
/*    */         }
/*    */ 
/*    */         
/*    */         public void load(FileGetter file) throws IOException {
/* 49 */           WArmyAI.this.war.load(file);
/* 50 */           WArmyAI.this.rebel.load(file);
/*    */         }
/*    */ 
/*    */         
/*    */         public void clear() {
/* 55 */           WArmyAI.this.war.clear();
/* 56 */           WArmyAI.this.rebel.clear();
/*    */         }
/*    */       };
/*    */   }
/*    */   public void update(WArmy a) {
/* 61 */     this.rebel.updateRebel(a);
/*    */   }
/*    */   
/*    */   public void update(double ds) {
/* 65 */     for (Faction f : this.fas) {
/* 66 */       this.war.planForWar(f);
/*    */     }
/* 68 */     this.fas.clearSloppy();
/* 69 */     this.war.update(ds);
/*    */   }
/*    */   
/*    */   public void init(Faction f) {
/* 73 */     this.war.init(f);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\WArmyAI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */