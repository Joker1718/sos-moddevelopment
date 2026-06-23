/*    */ package game.raiding;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import java.io.Serializable;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER_TRANS;
/*    */ import util.text.INSERT;
/*    */ import util.text.Inserter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RaiderText
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 21 */   public LinkedList<String> demandBody = new LinkedList();
/* 22 */   public LinkedList<String> rejected = new LinkedList();
/* 23 */   public LinkedList<String> payed = new LinkedList();
/* 24 */   public LinkedList<String> afterRaid = new LinkedList();
/*    */   
/* 26 */   public static final Inserter<Raider> insert = new Inserter();
/*    */   static {
/* 28 */     insert.getClass();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     insert.join(INSERT.indu, new GETTER_TRANS<Raider, Induvidual>()
/*    */         {
/*    */           public Induvidual get(Raider f)
/*    */           {
/* 39 */             return f.indu;
/*    */           }
/*    */         });
/*    */     
/* 43 */     insert.join(INSERT.faction, new GETTER_TRANS<Raider, Faction>()
/*    */         {
/*    */           public Faction get(Raider f)
/*    */           {
/* 47 */             return (Faction)FACTIONS.player();
/*    */           }
/*    */         });
/*    */     
/* 51 */     insert.join(INSERT.player, new GETTER_TRANS<Raider, Integer>()
/*    */         {
/*    */           public Integer get(Raider f)
/*    */           {
/* 55 */             return Integer.valueOf(RND.rInt());
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(Raider raider, boolean first) {
/* 67 */     RaiderTextsRace tt = (raider.indu.race()).info.raiderMess;
/* 68 */     if (first) {
/* 69 */       insert(this.demandBody, raider, new CharSequence[] { (CharSequence)tt.greetings.rnd(), (CharSequence)tt.mids.rnd(), (CharSequence)tt.bodies.rnd(), (CharSequence)tt.ends.rnd() });
/*    */     } else {
/* 71 */       insert(this.demandBody, raider, new CharSequence[] { (CharSequence)tt.rgreetings.rnd(), (CharSequence)tt.rmids.rnd(), (CharSequence)tt.rbodies.rnd(), (CharSequence)tt.rends.rnd() });
/* 72 */     }  insert(this.payed, raider, new CharSequence[] { (CharSequence)tt.payed.rnd() });
/* 73 */     insert(this.rejected, raider, new CharSequence[] { (CharSequence)tt.rejected.rnd() });
/* 74 */     insert(this.afterRaid, raider, new CharSequence[] { (CharSequence)tt.afterRaid.rnd() });
/*    */   }
/*    */   
/*    */   public void insert(LinkedList<String> res, Raider raider, CharSequence... sources) {
/* 78 */     res.clear(); byte b; int i; CharSequence[] arrayOfCharSequence;
/* 79 */     for (i = (arrayOfCharSequence = sources).length, b = 0; b < i; ) { CharSequence s = arrayOfCharSequence[b];
/* 80 */       Str.TMP.clear();
/* 81 */       Str.TMP.add(s);
/*    */ 
/*    */       
/* 84 */       insert.set(Str.TMP, raider);
/* 85 */       res.add(String.valueOf(Str.TMP));
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaiderText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */